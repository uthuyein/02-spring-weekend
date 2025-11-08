package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.Messager;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private Messager mess;

	@GetMapping
	String index(ModelMap map) {
		map.put("message", mess.getMessage());
		return "home";
	}
}
