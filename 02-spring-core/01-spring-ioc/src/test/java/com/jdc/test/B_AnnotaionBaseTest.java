package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.Messages;

public class B_AnnotaionBaseTest {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext(Messages.class)){
			var mess = context.getBean(Messages.class);
			mess.setMessage("Hello annotation application context");
			System.out.println(mess.getMessage());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
