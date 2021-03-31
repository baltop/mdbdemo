package com.esez.mdb;



import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esez.mdb.dao.postgres.TagInfoDao;
import com.esez.mdb.service.UserService;



@SpringBootTest
public class UserTest {

	@Autowired
	private UserService userService;


	@Test
	public void testGetAll() {

		try {
			userService.saveUser();
		} catch (Exception e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}

		



	}


}