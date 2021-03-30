package com.esez.mdb;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esez.mdb.model.postgres.User;
import com.esez.mdb.repository.postgres.UserPostgresRepository;



@SpringBootTest
public class PostgresRepoTest {
	@Autowired
	UserPostgresRepository userRepository;
	
	@Test
	public void userTest() throws SQLException {
		User user = new User();
		user.setId(1000006);
		user.setName("maddog");


		User newuser = userRepository.save(user);
		assertThat(newuser).isNotNull();
		User existinguser = userRepository.findByName(newuser.getName());
		assertThat(existinguser).isNotNull();
		User nonExistinguser = userRepository.findByName("superman");
		assertThat(nonExistinguser).isNull();
	}
}
