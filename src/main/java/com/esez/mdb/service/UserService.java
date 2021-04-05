package com.esez.mdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esez.mdb.dao.postgres.TagInfoDao;
import com.esez.mdb.model.postgres.User;


// service 필요없으면 굳이 만들지 말것. 이 파일은  테스트용.
@Service
public class UserService {

	@Autowired
	TagInfoDao tagInfoDao;
	
	public void saveUser() throws Exception {
		
		User user = new User();
		user.setName("zium");
		tagInfoDao.create(user);
	}
	
}
