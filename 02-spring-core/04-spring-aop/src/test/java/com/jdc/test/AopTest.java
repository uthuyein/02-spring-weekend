package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dto.MyClient;

@SpringJUnitConfig(locations = "classpath:context.xml")
public class AopTest {

	@Autowired
	MyClient client;
	
	@Test
	void test() {
		client.doSomething();
	}
}
