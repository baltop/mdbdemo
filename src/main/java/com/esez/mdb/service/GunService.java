package com.esez.mdb.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esez.mdb.model.tibero.GunTest;
import com.esez.mdb.repository.tibero.GunTestTiberoRepository;


// service 필요없으면 굳이 만들지 말것. 이 파일은  테스트용.
@Service
public class GunService {

	@Autowired
    private GunTestTiberoRepository gunRepository;
	
	@Scheduled(fixedDelay = 5000)
	public void insertGunTestData() {
		Random random = new Random();
		int companyRandomCnt = 0;
		int nameRandomCnt = 0;
		GunTest gunTest = new GunTest();
		String[] companyArray = {"1중대", "2중대", "3중대"};
		String[] nameArray = {"보관", "출타자", "파견", "근무", "훈련"};
		
		companyRandomCnt = random.nextInt(4);
		nameRandomCnt = random.nextInt(5);
		
		gunTest.setCompany(companyArray[companyRandomCnt]);
		gunTest.setName(nameArray[nameRandomCnt]);
		gunTest.setValue(random.nextInt(100));
		
		gunRepository.save(gunTest);
		System.out.println("insert Gun Test data");
	}
}
