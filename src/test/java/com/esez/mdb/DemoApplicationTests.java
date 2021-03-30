package com.esez.mdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.esez.mdb.model.postgres.User;
import com.esez.mdb.repository.postgres.UserPostgresRepository;



@SpringBootTest(webEnvironment = RANDOM_PORT)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
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
	
	
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void 메인페이지_로딩() {
		// when
		String body = this.restTemplate.getForObject("/esez/car", String.class);

		System.out.println(body);
		// then
		assertThat(body).contains("toyota");
	}
}
