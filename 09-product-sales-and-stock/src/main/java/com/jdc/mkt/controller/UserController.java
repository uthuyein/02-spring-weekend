package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	@GetMapping
	String index() {
		return "users/user-list";
	}
	
	@PostMapping("/user")
	String saveUser(String redirectUrl) {		
		return "redirect:"+redirectUrl;
	}
	
	@GetMapping("form")
	String addForm() {
		return "users/user-add";
	}

}
