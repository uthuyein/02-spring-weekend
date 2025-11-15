package com.jdc.mkt.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/controller/legacy")
public class LegacyController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		var model = new ModelAndView("controllers/legacy");	
		model.getModelMap().put("message", "Use from legacy controller");
		return model;
	}

}
