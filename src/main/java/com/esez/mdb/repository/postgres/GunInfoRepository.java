package com.esez.mdb.repository.postgres;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.esez.mdb.model.postgres.GunInfo;


public interface GunInfoRepository extends JpaRepository<GunInfo, Integer> {
	@Query("SELECT P FROM GunInfo P WHERE LIMITED 6")
	List<GunInfo> findbylimit(Integer id, Sort sort);
}
