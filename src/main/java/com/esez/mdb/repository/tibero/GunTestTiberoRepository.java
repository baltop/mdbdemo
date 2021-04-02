package com.esez.mdb.repository.tibero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.esez.mdb.model.tibero.GunTest;


public interface GunTestTiberoRepository extends JpaRepository<GunTest, Integer> {
	
	public List<GunTest> findByCompany(@Param("company") String company);
	
	public List<GunTest> findByName(@Param("name") String name);
}

