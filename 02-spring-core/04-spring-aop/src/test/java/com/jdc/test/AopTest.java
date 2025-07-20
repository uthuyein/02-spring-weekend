package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dto.MyClient;
import com.jdc.utils.ShowLogger;

@SpringJUnitConfig(locations = "classpath:context-args.xml")
public class AopTest {

	@Autowired
	MyClient client;
	
	@Test
	void test() {
		//client.getMessage();
		//client.doSomething();
		int result = client.divided(30, 5);
		ShowLogger.output(result+"");
	}
}
