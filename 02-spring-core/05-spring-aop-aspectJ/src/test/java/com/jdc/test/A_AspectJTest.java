package com.jdc.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.AppConfig;
import com.jdc.dto.MyDefaultService;

@SpringJUnitConfig(classes = AppConfig.class)
public class A_AspectJTest {

	@Autowired
	//@Qualifier("custom")
	MyDefaultService service;
	
	@Test
	void testException() {
		//service.setData("Test Message", 0);
		service.getCount();
	}
	
	@Test
	@Disabled
	void testAdvice() {
		service.doSomething();
	}
}
