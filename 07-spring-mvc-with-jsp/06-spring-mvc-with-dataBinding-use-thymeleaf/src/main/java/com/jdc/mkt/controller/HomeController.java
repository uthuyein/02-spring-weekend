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
import com.jdc.mkt.model.entity.Member;
import com.jdc.mkt.model.repo.MemberRepo;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
	
	@Autowired
	private MemberRepo repo;
	
	@Autowired
	MemberConverter stringToMember;
	
//	@InitBinder
//	void converterConfig(WebDataBinder binder) {
//		if(binder.getConversionService() instanceof ConfigurableConversionService registery) {
//			registery.addConverter(stringToMember);
//		}
//	}

	@GetMapping
	String index(ModelMap map) {
		map.put("members", repo.findAll());
		return "home";
	}
	
	@GetMapping("send")
	String find(@RequestParam Member member) {
		System.out.println("Member ::: "+member.getName()+"\t"+member.getMemberType());
		return "redirect:/home";
	}
	
	
}
