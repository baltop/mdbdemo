package com.esez.mdb.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esez.mdb.model.postgres.GunInfo;
import com.esez.mdb.model.postgres.SmartGun;
import com.esez.mdb.repository.postgres.GunInfoRepository;
import com.esez.mdb.repository.postgres.SmartGunRepository;
 
@RestController
@RequestMapping("/api/v1.5")
public class YsrController {
 
    @Autowired
    private SmartGunRepository smartGunRepository;
    @Autowired
    private GunInfoRepository gunInfoRepository; 
    
    @GetMapping("/gun/list")
    @ResponseBody
    public List<Data> getMasterUser(@RequestParam(value= "siteId", required = false, defaultValue = "savegun1")String siteId){
    	List<Data> list=new ArrayList<>();
    	Data data = new Data();
    	if(siteId.equals("savegun1")) {
    		data.setName("보관");
        	data.setValue(45);
        	list.add(data);
        	data = new Data();
        	data.setName("근무");
        	data.setValue(10);
        	list.add(data);
        	data = new Data();
        	data.setName("파견");
        	data.setValue(10);
        	list.add(data);
        	data = new Data();
        	data.setName("출타자");
        	data.setValue(10);
        	list.add(data);
        	data = new Data();
        	data.setName("훈련");
        	data.setValue(10);
        	list.add(data);
    	}else if(siteId.equals("savegun2")){
    		data.setName("보관");
        	data.setValue(45);
        	list.add(data);
        	data = new Data();
        	data.setName("근무");
        	data.setValue(12);
        	list.add(data);
        	data = new Data();
        	data.setName("파견");
        	data.setValue(12);
        	list.add(data);
        	data = new Data();
        	data.setName("출타자");
        	data.setValue(13);
        	list.add(data);
        	data = new Data();
        	data.setName("훈련");
        	data.setValue(15);
        	list.add(data);
    	}else if(siteId.equals("savegun3")){
    		data.setName("보관");
        	data.setValue(45);
        	list.add(data);
        	data = new Data();
        	data.setName("근무");
        	data.setValue(18);
        	list.add(data);
        	data = new Data();
        	data.setName("파견");
        	data.setValue(19);
        	list.add(data);
        	data = new Data();
        	data.setName("출타자");
        	data.setValue(15);
        	list.add(data);
        	data = new Data();
        	data.setName("훈련");
        	data.setValue(20);
        	list.add(data);
    	}
        return list;
    }
    @GetMapping("/company/list")
    @ResponseBody
    public List<SmartGun> getCompany(@RequestParam(value= "siteId", required = false, defaultValue = "savegun1")String siteId){
    	String company = "1중대";
    	if(siteId.equals("savegun1")){
    		company = "1중대";
    	}else if(siteId.equals("savegun2")){
    		company = "2중대";
    	}else if(siteId.equals("savegun3")){
    		company = "3중대";
    	}
    	return smartGunRepository.findAllByCompany(company);
    	
    }
    
    @GetMapping("/table/list")
    @ResponseBody
    public List<GunInfo> getGunInfo(@RequestParam(value= "siteId", required = false, defaultValue = "mytable")String siteId){
    	System.out.print("이것:"+gunInfoRepository.findAll());
    	return gunInfoRepository.findbylimit(6, Sort.by("id"));
    }
    
    public class Data{
    	String name;
    	Integer value;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
    }
}
