package com.esez.mdb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.esez.mdb.model.tibero.SolStatTest;
import com.esez.mdb.repository.tibero.SolStatTestTiberoRepository;

@RestController
@RequestMapping("/sol/*")
public class SolTestController {
	
	@Autowired
    private SolStatTestTiberoRepository sstRepository;
	
	@PostMapping("/stat")
	@ResponseBody
	public List<SolStatTest> getList(){
		List<SolStatTest> testList = new ArrayList<>();
		testList = sstRepository.findAll();
		return testList;
	}
	
	@Scheduled(fixedDelay = 10000)
	public void insertSolTestData() {
		Random random = new Random();
		SolStatTest solStatTest = new SolStatTest();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date now = new Date();
		
		String[] soldierNumArray = {"14-13241", "14-71033014", "09-506938", "15-70010100"};
		String[] reason = {"훈련", "근무", "보관"};
		String[] isOpen = {"개", "폐"};
		
		int soldierRandomNo = random.nextInt(soldierNumArray.length);
		int reasonRandomNo = random.nextInt(reason.length);
		int isOpenRandomNo = random.nextInt(isOpen.length);
		
		solStatTest.setNum(soldierNumArray[soldierRandomNo]);
		solStatTest.setReason(reason[reasonRandomNo]);
		solStatTest.setStatus(isOpen[isOpenRandomNo]);
		solStatTest.setNow(now);
		
		sstRepository.save(solStatTest);		
	}
	
	@GetMapping("/resaon/{reasonType}")
	public List<SolStatTest> getListByReason(
			@PathVariable(value ="reasonType", required=true) String resaonType 
			){
		List<SolStatTest> sstList = new ArrayList<>();
		Map<String, String> reasonMap = new HashMap<String, String>();
		
		String[] reasonEnType = {"training", "working", "keeping"};
		String[] reasonKoType = {"훈련", "근무", "보관"};
		
		for(int i=0;i<reasonEnType.length;i++) {
			reasonMap.put(reasonEnType[i], reasonKoType[i]);
		}
		sstList = sstRepository.findByReason(reasonMap.get(resaonType));
		
		return sstList;
	}
	
	@GetMapping("/status/{statusType}")
	public List<SolStatTest> getListByStatus(
			@PathVariable(value="statusType", required=true) String statusType
			){
		List<SolStatTest> sstList = new ArrayList<>();
		Map<String, String> statusMap = new HashMap<>();
		String[] statusEnType = {"open", "closed"};
		String[] statusKoType = {"개", "폐"};
		
		for(int i=0;i<statusEnType.length;i++) {
			statusMap.put(statusEnType[i], statusKoType[i]);
		}
		sstList = sstRepository.findByStatus(statusMap.get(statusType));
	
		return sstList;
	}
	
	@PostMapping("/latest")
	public List<SolStatTest> getListByLatest(){
		List<SolStatTest> sstList = new ArrayList<>();
		sstList = sstRepository.findByLatestTime();
		return sstList;
	}
	
}
