package com.jdc.dto;

import org.springframework.stereotype.Component;


public class MyCustomService implements MyService {

	@Override
	public void doWork() {
		System.out.println("Do something from my custom service.");
	}

}
