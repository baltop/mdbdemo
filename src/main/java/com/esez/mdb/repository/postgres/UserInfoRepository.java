package com.esez.mdb.repository.postgres;



import org.springframework.data.jpa.repository.JpaRepository;

import com.esez.mdb.model.postgres.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	UserInfo findByUserNm(String userNm);


}
