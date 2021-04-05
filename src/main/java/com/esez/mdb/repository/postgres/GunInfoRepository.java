package com.esez.mdb.repository.postgres;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.esez.mdb.model.postgres.GunInfo;


public interface GunInfoRepository extends JpaRepository<GunInfo, Integer> {
	@Query(value="select * from zium.guninfo order by id desc limit 3;", nativeQuery=true)
	List<GunInfo> findByLimit();

//	List<GunInfo> findLast6byGunInfo(String id, Sort sort);
//	@Query("")
//	List<GunInfo>findLimited(...., new PageRequest(0,10));
}
