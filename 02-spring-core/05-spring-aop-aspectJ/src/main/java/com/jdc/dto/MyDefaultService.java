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

}
