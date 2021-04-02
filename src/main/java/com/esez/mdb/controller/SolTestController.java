package com.esez.mdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
