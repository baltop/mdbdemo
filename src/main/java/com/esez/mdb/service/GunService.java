package com.esez.mdb.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esez.mdb.model.postgres.SmartGun;
import com.esez.mdb.repository.postgres.GunTestPostgresRepository;

// service 필요없으면 굳이 만들지 말것. 이 파일은  테스트용.
@Service
public class GunService {

	@Autowired
    private GunTestPostgresRepository gunRepository;
	
	
	@Transactional
//	@Scheduled(fixedDelay = 5000)
	public void updateGunTestData() {
		Random random = new Random();
		int idRandomCnt = 0;
		int valueRandom = 0;
		SmartGun smartGun = new SmartGun();
		
		idRandomCnt = random.nextInt(14)+1;
		valueRandom = random.nextInt(100);
//		
//		
		smartGun.setId(idRandomCnt);
		smartGun.setValue(valueRandom);
//		
//		
		try {
			gunRepository.update(smartGun);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		gunRepository.update(idRandomCnt,valueRandom);
		System.out.println("---------------------------------------------------"+idRandomCnt);
		System.out.println("insert Gun Test data");
	}
}
