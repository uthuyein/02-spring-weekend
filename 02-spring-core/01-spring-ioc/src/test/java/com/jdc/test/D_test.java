package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.config.BeanInitalizer;

public class D_test {

	@Test
	void test() {
		var context = new AnnotationConfigApplicationContext(BeanInitalizer.class);
		context.getBean("beanInitalizer");
		context.close();
	}
}
