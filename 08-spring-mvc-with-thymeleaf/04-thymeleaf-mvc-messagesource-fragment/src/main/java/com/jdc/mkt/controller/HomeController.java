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

import com.jdc.mkt.model.Card;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	String index() {
		return "home";
	}
	
	@GetMapping("images")
	String cardTest(ModelMap map) {
		map.put("cards", List.of(
				new Card("puppy1.jpeg","Happy Puppy","Happy puppy working on somewhere !"),
				new Card("puppy2.jpeg","Happy Group Puppy","Happy puppies working on somewhere !"),
				new Card("puppy3.jpeg","Cute Puppy","Happy puppy has white color !")));
		return "image-test";
	}
	
	@GetMapping("objects")
	String objectTest(ModelMap map) {
		map.put("ints", new int[] {2,3,4});
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
