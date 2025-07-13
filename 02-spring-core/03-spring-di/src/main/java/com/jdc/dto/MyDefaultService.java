package com.jdc.dto;

public class MyDefaultService implements MyService {

	@Override
	public void doWork() {
		System.out.println("Do something from my default service.");
	}

}
