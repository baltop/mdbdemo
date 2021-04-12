package com.esez.mdb.controller;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
//    	return gunInfoRepository.findAll();
    	List<GunInfo> bb = new ArrayList<>();    	
    	bb = gunInfoRepository.findByLimit();
    	System.out.println(((GunInfo)bb.get(0)).getDate());
    	return bb;
    }
}
