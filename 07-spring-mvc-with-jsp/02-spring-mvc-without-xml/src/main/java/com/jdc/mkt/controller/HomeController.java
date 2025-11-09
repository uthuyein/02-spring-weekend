package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.service.MessengerService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private MessengerService service;
	
	@GetMapping
	String index(ModelMap map) {
		
		map.put("messengers", service.getAllMessages());
		return "home";
	}
}
