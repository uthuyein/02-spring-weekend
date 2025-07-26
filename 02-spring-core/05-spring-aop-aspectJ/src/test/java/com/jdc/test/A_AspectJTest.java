package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.AppConfig;
import com.jdc.dto.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class A_AspectJTest {

	@Autowired
	@Qualifier("custom")
	MyService service;
	
	@Test
	void test() {
		service.doSomething();
	}
}
