package com.jdc.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClient {

	// @Autowired
	// if more than one injector ,field name will be the bean name
	private Optional<MyService> optional;

	public MyClient(Optional<MyService> optional) {
		this.optional = optional;
	}

//	@Autowired
//	public void setDefault( MyService service) {
//		this.myDefaultService = service;
//	}

	public void doSomething() {
		optional.ifPresentOrElse(s -> s.doWork(), 
				() -> System.out.println("There is no service"));
		
	}
}
