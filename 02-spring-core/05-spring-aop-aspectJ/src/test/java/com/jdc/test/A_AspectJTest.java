package com.jdc.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.AppConfig;
import com.jdc.dto.MyEmployeeService;
import com.jdc.dto.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class A_AspectJTest {

	@Autowired
	//@Qualifier("custom")
	MyService service;
	
	@Autowired
	MyEmployeeService emp;
	
	@Test
	void testCombine() {
		emp.sale();
		emp.save(null);
		
		if(emp instanceof MyService ser) {
			ser.doSomething();
		}
	}
	
//	@Test
//	void testException() {
//		//service.setData("Test Message", 0);
//		service.getCount("50");
//	}
	
	@Test
	@Disabled
	void testAdvice() {
		service.doSomething();
	}
}
