package com.jdc.mkt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.mkt.binding.MemberConverter;
import com.jdc.mkt.binding.MemberFormatter;
import com.jdc.mkt.model.entity.Member;
import com.jdc.mkt.model.repo.MemberRepo;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
	
	@Autowired
	private MemberRepo repo;
	
	@Autowired
	MemberFormatter formatter;
	@Autowired
	MemberConverter stringToMember;
	
	
//	@InitBinder
//	void converterConfig(WebDataBinder binder) {
//		
//		if(binder.getConversionService() instanceof ConfigurableConversionService registery) {
//			registery.addConverter(stringToMember);
//		}
//		//binder.addCustomFormatter(formatter);
//	}
	
	

	@GetMapping
	String index(ModelMap map) {	
		map.put("members", repo.findAll());
		return "home";
	}
	
	@GetMapping("sendConvert")
	String findNumber(@RequestParam Member number ,ModelMap map) {
		
		map.put("memberConvert", Optional.ofNullable(number).orElse(new Member()));
		return "/home";
	}
	
	@GetMapping("sendFormat")
	String findName(@RequestParam Member name ,ModelMap map) {
		System.out.println("member type :"+name);
		map.put("memberFormat", Optional.ofNullable(name).orElse(new Member()));
		return "/home";
	}
	
	@ModelAttribute("memberConvert")
	Member getMemberConvert() {
		var mem = new Member();
		mem.setName("No Member");
		return mem;
	}
	
	@ModelAttribute("memberFormat")
	Member getMemberFormat() {
		var mem = new Member();
		mem.setName("No Member");
		return mem;
	}
}
