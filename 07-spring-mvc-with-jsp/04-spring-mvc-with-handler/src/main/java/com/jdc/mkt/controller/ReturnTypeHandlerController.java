package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class ReturnTypeHandlerController {
	
	@GetMapping
	String index() {
		return "returns/stringview";
	}

	//url => /returns/string
	@GetMapping("string")
	String stringReturn() {
		return "returns/stringview";
	}
	
	//url => /returns/model
	@GetMapping("model")
	ModelAndView viewObjReturn() {
		var mod = new ModelAndView("returns/modelview");
		return mod;
	}
	
	//url => /returns/noreturn	
	@GetMapping("noreturn")
	void noReturn() {}
	
	//url => /returns/redirect	
	@GetMapping("redirect")
	String redirect() {
		return "redirect:/returns/string";
	}
}
