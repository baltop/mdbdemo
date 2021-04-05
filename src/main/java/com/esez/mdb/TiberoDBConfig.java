package com.esez.mdb;

import com.esez.mdb.model.tibero.User;
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
import org.springframework.jdbc.core.JdbcTemplate;
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
@EnableJpaRepositories(entityManagerFactoryRef = "tiberoEntityManager", transactionManagerRef = "tiberoTransactionManager", basePackages = "com.esez.mdb.repository.tibero")
public class TiberoDBConfig {

	@Autowired
	private Environment env;

	@Bean(name = "tiberoDB")
	public DataSource tiberoDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.tibero.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.tibero.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.tibero.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.tibero.datasource.password"));
		return dataSource;
	}

	@Bean(name = "jdbcTemplateTibero")
	public JdbcTemplate jdbcTemplate1(@Qualifier("tiberoDB") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean(name = "tiberoEntityManager")
	public LocalContainerEntityManagerFactoryBean tiberoEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(tiberoDataSource()).properties(hibernateProperties()).packages(User.class)
				.persistenceUnit("tiberoPU").build();
	}

	@Bean(name = "tiberoTransactionManager")
	public PlatformTransactionManager tiberoTransactionManager(
			@Qualifier("tiberoEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map hibernateProperties() {
		Resource resource = new ClassPathResource("hibernate.properties");

		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);

			Map map = properties.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue()));
			map.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			return map;
		} catch (IOException e) {
			Map map = new HashMap();
			map.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			return map;
		}
	}
}
