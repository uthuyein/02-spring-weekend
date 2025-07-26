package com.jdc.dto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.jdc.utils.ShowLogger;

@Component 
@Primary
public class MyDefaultService implements MyService{

	@Override
	public void doSomething() {
		ShowLogger.output("My Default Service !");
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
