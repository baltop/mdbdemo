package com.esez.mdb.repository.postgres;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.esez.mdb.model.postgres.GunInfo;


public interface GunInfoRepository extends JpaRepository<GunInfo, Integer> {
	@Query(value="select * from zium.guninfo order by id desc limit 6;", nativeQuery=true)
	List<GunInfo> findByLimit();

}
