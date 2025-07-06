package com.jdc.beans;

public class MyDefaultService implements MyService{

	@Override
	public void create() {
		System.out.println("Call default service.");
	}

}
