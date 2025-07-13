package com.jdc.dto;

public class MyCustomService implements MyService {

	@Override
	public void doWork() {
		System.out.println("Do something from my custom service.");
	}

}
