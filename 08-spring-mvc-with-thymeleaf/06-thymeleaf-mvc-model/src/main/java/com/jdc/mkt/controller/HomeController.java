package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.User;


@Controller
@RequestMapping({"/"})
public class HomeController {
	
	@GetMapping
	String index() {	
		return "home";
	}
	

	@PostMapping("/save")
	String save(@ModelAttribute User user) {
		System.out.println(user);
		return "redirect:/home";
	}
	
	
}
