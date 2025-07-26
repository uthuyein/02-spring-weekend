package com.jdc.dto;

import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component("custom")
public class MyCustomService implements MyService{

	@Override
	public void doSomething() {
		ShowLogger.output("My Custom Service !");
	}

}
