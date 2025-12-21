package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jdc.mkt.model.Counter;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Controller

@RequestMapping("/counter")
public class CounterController {

	@Autowired
	@Qualifier("requestScope")
	Counter requestCounter;
	
	@Autowired
	@Qualifier("sessionScope")
	Counter sessionCounter;
	
	@Autowired
	@Qualifier("applicationScope")
	Counter applicationCounter;
	
	@Autowired
	private ServletContext context;
	
	@PostConstruct
	void loadContext() {
		context.setAttribute("appCount", new Counter());
	}
	
	@GetMapping
	String index(ModelMap map  ,@RequestAttribute Counter reqCount,@SessionAttribute Counter sessionCount ) {
		map.put("requestCount", requestCounter.countUp());
		map.put("sessionCount", sessionCounter.countUp());
		map.put("applicationCount", applicationCounter.countUp());
		
		map.put("reqAttribute", reqCount.countUp());
		map.put("sessionAttribute", sessionCount.countUp());
		
		Counter contextCounter = (Counter) context.getAttribute("appCount");		
		map.put("appCount", contextCounter.countUp() );
		
		return "counter";
	}
	
	@ModelAttribute
	void loadModel(HttpServletRequest request) {
		
		if(null == request.getAttribute("reqCount") )
		request.setAttribute("reqCount", new Counter());
		
		var session = request.getSession(true);
		
		if(null == session.getAttribute("sessionCount") )
		session.setAttribute("sessionCount", new Counter());
		
		
	}
}
