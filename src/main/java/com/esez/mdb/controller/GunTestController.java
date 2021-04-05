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

import com.esez.mdb.model.tibero.GunTest;
import com.esez.mdb.repository.tibero.GunTestTiberoRepository;

@RestController
@RequestMapping("/gun/*")
public class GunTestController {
	
	@Autowired
    private GunTestTiberoRepository gunRepository;
	
	@PostMapping("/main")
	@ResponseBody
	public List<GunTest> getList(){
		List<GunTest> gunList = new ArrayList<>();
		gunList = gunRepository.findAll();
		return gunList;
	}
	
	@Scheduled(fixedDelay = 5000)
	public void insertGunTestData() {
		Random random = new Random();
		int companyRandomCnt = 0;
		int nameRandomCnt = 0;
		GunTest gunTest = new GunTest();
		String[] companyArray = {"1중대", "2중대", "3중대", "본부중대"};
		String[] nameArray = {"보관", "출타자", "파견", "근무", "훈련"};
		
		companyRandomCnt = random.nextInt(4);
		nameRandomCnt = random.nextInt(5);
		
		gunTest.setCompany(companyArray[companyRandomCnt]);
		gunTest.setName(nameArray[nameRandomCnt]);
		gunTest.setValue(random.nextInt(100));
		
		gunRepository.save(gunTest);
		System.out.println("insert Gun Test data");
	}
	
	@GetMapping("/company/{companyNo}")
	public List<GunTest> getListByCompany(
			@PathVariable(value="companyNo", required=true) int companyNo
			){
		String[] companyArray = { "본부중대", "1중대", "2중대", "3중대"};
		List<GunTest> gunList = new ArrayList<>();
		gunList = gunRepository.findByCompany(companyArray[companyNo]);
		return gunList;
	}
	
	
	@GetMapping("/name/{nameKey}")
	public List<GunTest> getListByName(
			@PathVariable(value="nameKey", required=true) String nameKey
			){
		Map<String, String> nameMap = new HashMap<>();
		String[] nameEnArray = {"keep", "outing", "dispath", "working", "training"};
		String[] nameKoArray = {"보관", "출타자", "파견", "근무", "훈련"};
		for(int i=0;i<nameKoArray.length;i++) {
			nameMap.put(nameEnArray[i], nameKoArray[i]);
		}
		
		List<GunTest> gunList = new ArrayList<>();
		gunList = gunRepository.findByName(nameMap.get(nameKey));
		return gunList;
	}
	
	
	
}
