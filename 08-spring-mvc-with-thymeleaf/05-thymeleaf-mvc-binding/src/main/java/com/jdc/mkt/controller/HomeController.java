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


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	MemberConverter converter;
	
	@InitBinder
	void converterConfig(WebDataBinder binder) {
		
		if(binder.getConversionService() instanceof ConfigurableConversionService registery) {
			registery.addConverter(converter);
		}
		
	}

	@GetMapping
	String index(ModelMap map) {	
		return "home";
	}
	

	@GetMapping("sendConvert")
	String findName(@RequestParam Member idMember ,ModelMap map) {
		
		map.put("memberConvert", idMember);
		return "/home";
	}
	
	
}
