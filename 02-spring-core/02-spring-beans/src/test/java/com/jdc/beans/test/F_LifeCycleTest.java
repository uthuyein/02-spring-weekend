package com.jdc.beans.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.lifecycle.MyClient;

public class F_LifeCycleTest {

	@Test
	void annotationTest() {
		try{
			var context = new AnnotationConfigApplicationContext(MyClient.class);
			var bean = context.getBean("myClient");
			assertNotNull(bean);
			context.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	@Disabled
	void xmlTest() {
		try{
			var context = new GenericXmlApplicationContext("classpath:context-lifecycle.xml");
			var bean = context.getBean("client");
			assertNotNull(bean);
			context.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
