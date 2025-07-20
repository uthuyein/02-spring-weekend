package com.jdc.dto;

import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component
public class MyClient implements MyClientInter {

	@Override
	public void doSomething() {
		ShowLogger.output("Hello AOP");
	}
	
	public String getMessage() {
		return "return from getMessage";
	}
	
	public int divided(int a,int b) {
		return a/b;
	}
}
