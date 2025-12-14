package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.Counter;

@Controller
@RequestMapping("/counter")
public class CounterController {

	@Autowired
	@Qualifier("requestScope")
	Counter requestCounter;
	
	@Autowired
	@Qualifier("sessionScope")
	Counter sessionCounter;
	
	@Autowired
	@Qualifier("applicationScope")
	Counter applicationCounter;
	
	@GetMapping
	String index(ModelMap map) {
		map.put("requestCount", requestCounter.countUp());
		map.put("sessionCount", sessionCounter.countUp());
		map.put("applicationCount", applicationCounter.countUp());
		return "counter";
	}
}
