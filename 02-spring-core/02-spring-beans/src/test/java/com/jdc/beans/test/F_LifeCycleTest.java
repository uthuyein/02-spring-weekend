package com.jdc.beans.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class F_LifeCycleTest {

	@Test
	void xmlTest() {
		try(var context = new GenericXmlApplicationContext("classpath:context-lifecycle.xml")){
			var bean = context.getBean("client");
			assertNotNull(bean);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
