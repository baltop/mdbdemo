package com.esez.mdb.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esez.mdb.model.postgres.Cars;
import com.esez.mdb.model.tibero.CjmTest;
import com.esez.mdb.model.tibero.IotTest;
import com.esez.mdb.model.tibero.Test;
import com.esez.mdb.repository.postgres.CarsPostgresRepository;
import com.esez.mdb.repository.postgres.UserPostgresRepository;
//import com.esez.mdb.repository.tibero.CjmTestTiberoRepository;
//import com.esez.mdb.repository.tibero.IotTestTiberoRepository;
//import com.esez.mdb.repository.tibero.TestTiberoRepository;
//import com.esez.mdb.repository.tibero.UserTiberoRepository;
import com.sun.istack.NotNull;
 
@RestController
@RequestMapping("/esez/*")
public class MainController {
	
	
	
	int cnt = 0;
	Random random = new Random();
 
    @Autowired
    private UserPostgresRepository postgresDao;
 
    @GetMapping("/master")
    @ResponseBody
    public List<com.esez.mdb.model.postgres.User> getMasterUser(){
        String data = "";
 
        List<com.esez.mdb.model.postgres.User> users = postgresDao.findAll();
//        for(com.esez.mdb.model.postgres.User user : users) {
//            data += user.getName();
//            data += "\n";
//        }
//        System.out.println(data);
        return users;
    }
 
//    @Autowired
//    private UserTiberoRepository tiberoDao;
 
//    @GetMapping("/stanby")
//    @ResponseBody
//    public List<com.esez.mdb.model.tibero.User> getStanbyUser(){
//        String data = "";
// 
//        List<com.esez.mdb.model.tibero.User> users = tiberoDao.findAll();
//        for(com.esez.mdb.model.tibero.User user : users) {
//            data += user.getName();
//            data += "\n";
//        }
//        System.out.println(data);
//        return users;
//    }
    
    @Autowired
    private CarsPostgresRepository carDao;
 
    @GetMapping("/car")
    @ResponseBody
    public Cars getCars(){
        String data = "";
 
        List<Cars> cars = carDao.findAll();
        for(Cars car : cars) {
            data += car.getMaker();
            data += "\n";
        }
        System.out.println(data);
        return cars.get(0);
    }
 
//    @Autowired
//    private TestTiberoRepository testDao;
// 
//    @GetMapping("/test")
//    @ResponseBody
//    public Test getTest(){
//        String data = "";
// 
//        List<Test> tests = testDao.findAll();
//        for(Test test : tests) {
//            data += test.getName();
//            data += "\n";
//        }
//        System.out.println(data);
//        return tests.get(0);
//    }
    
    @PostMapping("/tempreq")
    @ResponseBody
    public HashMap<String, Object> randomTemp() {
    	
    	int value = random.nextInt(10);
    	HashMap<String, Object> hashmap = new HashMap<String, Object>();
    	HashMap<String, Number> conMap = new HashMap<String, Number>();
    	HashMap<String, Object> m2mMap = new HashMap<String, Object>();
    	conMap.put("con", Math.round(value) );
    	m2mMap.put("m2m:cin",conMap);
    	
    	hashmap.put("to", "/iotCore/AE4619d935-2fac-41ac-a5e9-8d6ee4436c22/vm");
    	hashmap.put("fr", "SiotTestAE");
    	hashmap.put("rqi", "4781a4d1-5971-44e3-b309-28417deb8301");
    	hashmap.put("pc", m2mMap);
    	hashmap.put("op", 1);
    	hashmap.put("ty", 4);
    	hashmap.put("sec",0);
    	
    	return hashmap;    	
    }
    
//    @Autowired
//    private IotTestTiberoRepository iotTestDao;
//    
//    @Autowired
//    private CjmTestTiberoRepository cjmTestDao;
    
//    @Scheduled(fixedDelay = 60000)
//    @RequestMapping(value="/datatest/{livingRoomNo}", method = RequestMethod.GET)
//    public void insertRandomTestData() {
//    	
//    }
    
    @Scheduled(fixedDelay = 2000)
    public void insertTestData() {
    	    	
    	IotTest myTest = new IotTest();
    	int livingRoomNo = cnt%10;
    	float temperature = 0;
    	float humidity = 0; 
    	long now = 0;
    	
    	now = (long) System.currentTimeMillis() / 1000;
    	temperature = random.nextInt(5) + 15;
    	humidity = random.nextInt(10) + 30;
    	String stNow = Long.toString(now);
    	
    	myTest.setSenseTime(now);
    	myTest.setLivingRoomNo(livingRoomNo);
    	myTest.setHumidity(humidity);
    	myTest.setTemperature(temperature);
    	    		
//    	iotTestDao.save(myTest);
    	cnt++;

    }
    
//  @Scheduled(fixedDelay = 2000)
//  public void insertTestCjmData() {
//	  
//	System.out.println("insertTestData");
//  	
//  	CjmTest cjmTest = new CjmTest();
//  	int livingRoomNo = cnt%10;
//  	float temperature = 0;
//  	float humidity = 0; 
//  	long now = 0;
//  	
//  	now = (long) System.currentTimeMillis() / 1000;
//  	temperature = random.nextInt(5) + 15;
//  	humidity = random.nextInt(10) + 30;
//
//  	
//  	cjmTest.setSenseTime(now);
//  	cjmTest.setLivingRoomNo(livingRoomNo);
//  	cjmTest.setHumidity(humidity);
//  	cjmTest.setTemperature(temperature);
//  	    		
//  	cjmTestDao.save(cjmTest);
//  	cnt++;
//
//  }
    
    @GetMapping("/datatest/put/{livingRoomNo}")
    @ResponseBody
    public String putTestData(
    		@PathVariable(value="livingRoomNo", required=true) int livingRoomNo
    		) {
    	IotTest myTest =new IotTest();
    	float temperature = 0;
    	float humidity = 0; 
    	long now = 0;
    	
	    now = (long) System.currentTimeMillis() / 1000;
	    temperature = random.nextInt(5) + 15;
	    humidity = random.nextInt(10) + 30;
	    String stNow = Long.toString(now);
	    
	    myTest.setSenseTime(now);
	    myTest.setLivingRoomNo(livingRoomNo);
	    myTest.setHumidity(humidity);
	    myTest.setTemperature(temperature);
	        		
//	    iotTestDao.save(myTest);
    	
    	return "insert Data test success";
    }
    
    //cjm
    //test 미실행
    @GetMapping("/datatest/latest/{livingRoomNo}")
    @ResponseBody
    public List<IotTest> getLatestData(@PathVariable(value="livingRoomNo", required=true) int livingRoomNo){
    	List<IotTest> latestIotTestList = null ;
    	long now = (long) System.currentTimeMillis() / 1000;
    	//long 타입을 String변환 처리 애매
//    	latestIotTestList = iotTestDao.getLatestFindBySenseTime(livingRoomNo, now);
    	
    	return latestIotTestList;
    }
    
    //cjm
    //test 미실행
    @GetMapping("datatest/between/{livingRoomNo}")
    @ResponseBody
    public List<IotTest> getBetweenData(
    		@PathVariable(value="livingRoomNo", required=true) int livingRoomNo,
    		@RequestParam(value="startTime") @NotNull long startTime,
    		@RequestParam(value="endTime") @NotNull long endTime
    		){
    	List<IotTest> betweenDataList = null;
    	
    	long tempTime;
    	if(startTime > endTime) {
    		tempTime = startTime;
    		startTime = endTime;
    		endTime = tempTime;
    	}
    	
//    	betweenDataList = iotTestDao.findByLivingRoomNoAndSenseTimeBetween(livingRoomNo, startTime, endTime);
    	return betweenDataList;
    }
    
    @GetMapping("cjm/datatest/get/{livingRoomNo}")
    @ResponseBody
    public List<CjmTest> getData(
    		 @PathVariable(value="livingRoomNo", required=true) int livingRoomNo
    		){
    	List<CjmTest> dataList = new ArrayList<>();
//    	dataList = cjmTestDao.findByLivingRoomNo(livingRoomNo);
    	return dataList;
    }
    
    @GetMapping("cjm/datatest/between/{livingRoomNo}")
    @ResponseBody
    public List<CjmTest> getBetweenCjmData(
    		@PathVariable(value="livingRoomNo", required=true) int livingRoomNo,
    		@RequestParam(value="startTime") @NotNull long startTime,
    		@RequestParam(value="endTime") @NotNull long endTime
    		){
    	List<CjmTest> betweenDataList =  new ArrayList<>();
//    	betweenDataList = cjmTestDao.findALLByLivingRoomNoAndSenseTimeBetween(livingRoomNo, startTime, endTime);
    	
    	long temp;
    	if(startTime > endTime) {
    		temp = startTime;
    		startTime = endTime;
    		endTime = temp;
    	}
    	
//    	betweenDataList = cjmTestDao.qryTest(livingRoomNo, startTime, endTime);
    	return betweenDataList;
    }
    
    @GetMapping("cjm/datatest/latest/{livingRoomNo}")
    @ResponseBody
    public List<CjmTest> getLatestCjmData(@PathVariable(value="livingRoomNo", required=true) int livingRoomNo){
    	List<CjmTest> latestIotTestList = null ;
    	long now = (long) System.currentTimeMillis() / 1000;
    	//long 타입을 String변환 처리 애매
//    	latestIotTestList = cjmTestDao.getLatestFindBySenseTime(livingRoomNo, now);
    	
    	return latestIotTestList;
    }
    
    
    
    
    @PostMapping("/msg")
    @ResponseBody
    public String msg() {
    	return "post msg";
    }
    
    
}
