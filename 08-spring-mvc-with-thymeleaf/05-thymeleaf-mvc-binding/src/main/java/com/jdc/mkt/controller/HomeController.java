package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.mkt.binding.MemberConverter;
import com.jdc.mkt.model.Member;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	String index(ModelMap map) {	
		return "home";
	}
	

	@GetMapping("sendConvert")
	String sendConvert(@RequestParam(name = "id") Member member ,ModelMap map) {		
		map.put("memberConvert", member);
		return "/home";
	}
	
//	@GetMapping("sendFormat")
//	String sendFormat(@RequestParam(name = "name") Member member ,ModelMap map) {		
//		map.put("memberFormat", member);
//		return "/home";
//	}
	
	
}
