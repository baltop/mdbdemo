package com.esez.mdb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esez.mdb.model.postgres.SmartGun;
import com.esez.mdb.repository.postgres.GunTestPostgresRepository;
import com.esez.mdb.service.GunService;
import com.google.common.util.concurrent.Service;

@RestController
@RequestMapping("/gun/*")
public class GunTestController {

	@Autowired
	private GunTestPostgresRepository gunRepository;
	@Autowired
	private GunService gunService;

	@PostMapping("/main")
	@ResponseBody
	public List<SmartGun> getList() {
		List<SmartGun> gunList = new ArrayList<>();
		gunList = gunRepository.findAll();
		return getList();
	}

//	@Scheduled(fixedDelay = 5000)
//	public void insertGunTestData() {
//		Random random = new Random();
//		int companyRandomCnt = 0;
//		int nameRandomCnt = 0;
//		SmartGun smartGun = new SmartGun();
//		String[] companyArray = {"1중대", "2중대", "3중대", "본부중대"};
//		String[] nameArray = {"보관", "출타자", "파견", "근무", "훈련"};
//		
//		companyRandomCnt = random.nextInt(4);
//		nameRandomCnt = random.nextInt(5);
//		
//		smartGun.setCompany(companyArray[companyRandomCnt]);
//		smartGun.setName(nameArray[nameRandomCnt]);
//		smartGun.setValue(random.nextInt(100));
//		
//		gunRepository.save(smartGun);
//		System.out.println("insert Gun Test data");
//	}

//	@Scheduled(fixedDelay = 5000)
	@PostMapping("/company/cc")
	public void updateGunTestData() {
		gunService.updateGunTestData();
	}

	@PostMapping("/company/nn")
	public void insertGunInfoData() {
		gunService.insertGunInfoData();
	}

	@GetMapping("/company/{companyNo}")
	public List<SmartGun> getListByCompany(@PathVariable(value = "companyNo", required = true) int companyNo) {
		String[] companyArray = { "본부중대", "1중대", "2중대", "3중대" };
		List<SmartGun> gunList = new ArrayList<>();
		gunList = gunRepository.findByCompany(companyArray[companyNo]);
		return gunList;
	}

	@GetMapping("/name/{nameKey}")
	public List<SmartGun> getListByName(@PathVariable(value = "nameKey", required = true) String nameKey) {
		Map<String, String> nameMap = new HashMap<>();
		String[] nameEnArray = { "keep", "outing", "dispath", "working", "training" };
		String[] nameKoArray = { "보관", "출타자", "파견", "근무", "훈련" };
		for (int i = 0; i < nameKoArray.length; i++) {
			nameMap.put(nameEnArray[i], nameKoArray[i]);
		}

		List<SmartGun> gunList = new ArrayList<>();
		gunList = gunRepository.findByName(nameMap.get(nameKey));
		return gunList;
	}

}
