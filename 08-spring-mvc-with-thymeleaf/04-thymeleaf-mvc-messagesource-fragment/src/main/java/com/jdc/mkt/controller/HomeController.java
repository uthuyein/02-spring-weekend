package com.jdc.mkt.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	@GetMapping("objects")
	String objectTest(ModelMap map) {
		map.put("value", "Hello Java");
		map.put("number", 23232323);
		map.put("decimal", 232323.4523);
		map.put("array",new String[] {"1","2"});
		map.put("list",null);
		map.put("set", Set.of("Set 1","Set 2"));
		map.put("map", Map.of(1,"One",2,"Two"));
		return "basic-datatype";
	}
	
	@GetMapping("dates")
	String dateTest(ModelMap map) {
		map.put("date", new Date());
		map.put("calendar", Calendar.getInstance());
		map.put("temporal", LocalDate.now());
		return "expression-object";
	}
}
