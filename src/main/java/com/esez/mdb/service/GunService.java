package com.esez.mdb.service;


import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esez.mdb.model.postgres.GunInfo;
import com.esez.mdb.model.postgres.SmartGun;
import com.esez.mdb.repository.postgres.GunInfoRepository;
import com.esez.mdb.repository.postgres.GunTestPostgresRepository;

// service 필요없으면 굳이 만들지 말것. 이 파일은  테스트용.
@Service
public class GunService {

	@Autowired
    private GunTestPostgresRepository gunRepository;
	@Autowired
	private GunInfoRepository infoRepository;
	
	@Transactional
	@Scheduled(fixedDelay = 5000)
	public void updateGunTestData() {
		Random random = new Random();
		int idRandomCnt = 0;
		int valueRandom = 0;
		SmartGun smartGun = new SmartGun();
		idRandomCnt = random.nextInt(14)+1;
		valueRandom = random.nextInt(100);
		smartGun.setId(idRandomCnt);
		smartGun.setValue(valueRandom);
		gunRepository.update(smartGun);
//		gunRepository.update(idRandomCnt,valueRandom);
		System.out.println("update Gun Test data");
	}
	@Transactional
//	@Scheduled(fixedDelay = 5000)
	public void insertGunInfoData() {
		Random random = new Random();
		int num1 = 0;
		String num2 = null;
		int nameRandomCnt = 0;
		int statusRandomCnt = 0;
		
		Date time = new Date();

//		Calendar cal = Calendar.getInstance();
//		cal.setTime(time);
//		cal.add(Calendar.HOUR,9);
		
		GunInfo gunInfo = new GunInfo();
		num1 = random.nextInt(98)+1;
		num2 = ""+random.nextInt(9)+""+random.nextInt(9)+""+random.nextInt(9)+""+random.nextInt(9)+""+random.nextInt(9)+""+random.nextInt(9)+""+random.nextInt(9)+""+random.nextInt(9);
		String number = (""+num1+"-"+num2);
		
		String[] nameArray = {"보관", "출타자", "파견", "근무", "훈련"};
		String[] statusArray = {"개방","폐쇄"};
		nameRandomCnt = random.nextInt(5);
		statusRandomCnt = random.nextInt(2);
		
		gunInfo.setReson(nameArray[nameRandomCnt]);
		gunInfo.setNum(number);
		gunInfo.setStatus(statusArray[statusRandomCnt]);
		gunInfo.setDate(time);
		infoRepository.save(gunInfo);;
		
		System.out.println("insert Gun Test data");
	}
}
