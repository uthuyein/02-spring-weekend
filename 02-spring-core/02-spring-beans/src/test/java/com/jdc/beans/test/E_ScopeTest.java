package com.jdc.beans.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class E_ScopeTest {

	@Test
	void scopeXmlTest() {
		try (var context = new GenericXmlApplicationContext()) {
			context.load("classpath:context-scope.xml");
			context.refresh();
			var bean1 = context.getBean("client");
			var bean2 = context.getBean("client");
			assertTrue(bean1 == bean2);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Disabled
	void scopeAnnotationTest() {
		try(var context = new AnnotationConfigApplicationContext()){
			//context.register(MyClientConfig.class);
			context.scan("com.jdc.annotations");
			context.refresh();
			var config1 = context.getBean("myClientConfig");
			var config2 = context.getBean("myClientConfig");
			assertTrue(config1 ==  config2);
			
			var d1 = context.getBean("currentDate");
			var d2 = context.getBean("currentDate");
			assertFalse(d1 == d2);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
