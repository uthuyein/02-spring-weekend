package com.jdc.dto;

import org.springframework.stereotype.Component;

@Component
public class MyClient implements MyClientInter {

	@Override
	public void doSomething() {
		System.out.println("Hello AOP");
	}
	
}
