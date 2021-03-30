package com.esez.mdb;

import com.esez.mdb.model.postgres.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManager", 
						transactionManagerRef = "postgresTransactionManager", 
						basePackages = "com.esez.mdb.repository.postgres")
public class PostgresDBConfig {
	@Autowired
	private Environment env;

	@Primary
	@Bean
	public DataSource postgresDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.postgres.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.postgres.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.postgres.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.postgres.datasource.password"));
		return dataSource;
	}

	@Primary
	@Bean(name = "postgresEntityManager")
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(postgresDataSource()).properties(hibernateProperties()).packages(User.class)
				.persistenceUnit("postgresPU").build();
	}

	@Primary
	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager postgresTransactionManager(
			@Qualifier("postgresEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map hibernateProperties() {
		Resource resource = new ClassPathResource("hibernate.properties");

		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);

			Map map = properties.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue()));
            map.put("hibernate.dialect",
                    "org.hibernate.dialect.PostgreSQLDialect");
			return map;
		} catch (IOException e) {
        	Map map = new HashMap();
            map.put("hibernate.dialect",
                    "org.hibernate.dialect.PostgreSQLDialect");
            return map;
		}
	}
}
