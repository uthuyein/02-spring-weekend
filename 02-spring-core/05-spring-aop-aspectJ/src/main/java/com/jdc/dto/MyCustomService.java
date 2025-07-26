package com.jdc.dto;

import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component("custom")
public class MyCustomService implements MyService{

	@Override
	public void doSomething() {
		ShowLogger.output("My Custom Service !");
	}

	@Override
	public void setData(String message, int id) {
		if(null == message) {
			throw new RuntimeException("There is no message");
		}
		ShowLogger.output("Id :%-10d\tMessage :%-10s".formatted(id,message));
	}

	@Override
	public int getCount(String value) {
		return Integer.parseInt(value);
	}

}
