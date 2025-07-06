package com.jdc.beans.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.annotations.MyClientConfig;

public class D_JavaBaseTest {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext(MyClientConfig.class)){
			var date = context.getBean("qDate");
			assertNotNull(date);
			System.out.println(date);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
