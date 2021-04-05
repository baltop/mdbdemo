package com.esez.mdb.repository.postgres;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esez.mdb.model.postgres.SmartGun;


public interface SmartGunRepository extends JpaRepository<SmartGun, Integer> {

	List<SmartGun> findAllByCompany(String company);

}
