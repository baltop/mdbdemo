package com.esez.mdb;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esez.mdb.model.postgres.User;
import com.esez.mdb.model.postgres.UserInfo;
import com.esez.mdb.repository.postgres.UserInfoRepository;


@SpringBootTest
public class UserInfoTest {

	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	
	@Test
	public void userInfoTest() throws SQLException {
		UserInfo user = new UserInfo();
		user.setUserId("unkownid");
		user.setUserNm("김시시");


		UserInfo newuser = userInfoRepository.save(user);
		assertThat(newuser).isNotNull();
		UserInfo existinguser = userInfoRepository.findByUserNm(newuser.getUserNm());
		assertThat(existinguser).isNotNull();
		userInfoRepository.delete(existinguser);
		UserInfo nonExistinguser = userInfoRepository.findByUserNm("superman");
		assertThat(nonExistinguser).isNull();

	}
	
	
	
}
