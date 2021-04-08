package com.esez.mdb.repository.postgres;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.esez.mdb.model.postgres.SmartGun;


public interface GunTestPostgresRepository extends JpaRepository<SmartGun, Integer> {
	
	public List<SmartGun> findByCompany(@Param("company") String company);
	
	public List<SmartGun> findByName(@Param("name") String name);

//	@Modifying
//	@Query("UPDATE SmartGun s SET s.value = ?1 WHERE s.id = ?2")
//	void update(@Param("value") int value, @Param("id") int id);
	
	
	@Modifying
	@Query("update SmartGun set value = 2 where id = 16")
	int update(@Param("smartGun") SmartGun smartGun);
	
//	void update(@Param("value") int value, @Param("id") int id);
}
