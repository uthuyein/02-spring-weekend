package com.jdc.mkt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.dto.Course;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping
	String index() {
		return "standard";
	}
	
	@GetMapping("standard")
	String standard(ModelMap map) {
		map.put("title", "Using Standard dialect ");
		map.put("courses", List.of(
				new Course(1, "Java", "About Java Language"),
				new Course(2, "Python", "About Python Language"),
				new Course(3, "C#", "About C# Language")));
		return "standard";
	}
	
	@GetMapping("html5")
	String html(ModelMap map) {
		map.put("title", "Using HTML5 markup ");
		map.put("courses", List.of(
				new Course(1, "Angular", "About Angular Language"),
				new Course(2, "React", "About React Language"),
				new Course(3, "Vue", "About Vue Language")));
		return "html-attr";
	}
	
	@GetMapping("text")
	String textOutput(ModelMap map) {
		map.put("title", "Testing Text Output");
		map.put("message", "<b> Using Bold Text </b>");
		return "text-output";
	}
	
}
