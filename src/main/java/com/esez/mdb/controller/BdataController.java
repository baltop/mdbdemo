package com.esez.mdb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esez.mdb.model.postgres.ContentInstance;
import com.esez.mdb.repository.postgres.ContentInstanceRepository;

@RestController
@RequestMapping("/api/v1.5")
public class BdataController {

	@Autowired
	private ContentInstanceRepository contentRepository;

	@GetMapping("/silo/list")
	@ResponseBody
	public Map<String, String> getSiloList() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "mkyong");
		map.put("age", "37");

		return map;
	}
	
	@GetMapping("/con/list")
	@ResponseBody
	public List<ContentInstance> getConList() {
		List<ContentInstance> list = contentRepository.findAllByLabels("W");

		return list;
	}
	
	

}
