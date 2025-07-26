package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dto.MyClient;

@SpringJUnitConfig(locations = "classpath:context-custom-advice.xml")
public class AopTest {

	@Autowired
	MyClient client;

// @Autowired
//	MyService service;

	@Test
	void test() {
		client.doSomething();

//		client.getMessage();
//		client.divided(30, 10);
		// ShowLogger.output(result+"");
//		client.setData(new Data(1,"ss"));
//		
//		service.doWork();
//		service.doWorkOther();
	}
}
