package com.jdc.beans;

public class MyCustomService implements MyService{

	@Override
	public void create() {
		System.out.println("Call custom service.");
	}

}
