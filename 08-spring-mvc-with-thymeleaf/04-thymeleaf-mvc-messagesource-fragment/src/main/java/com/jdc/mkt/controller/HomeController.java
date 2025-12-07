package com.jdc.mkt.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	String index() {
		return "home";
	}
	
	@GetMapping("dates")
	String dateTest(ModelMap map) {
		map.put("date", new Date());
		map.put("calendar", Calendar.getInstance());
		map.put("temporal", LocalDate.now());
		return "expression-object";
	}
}
