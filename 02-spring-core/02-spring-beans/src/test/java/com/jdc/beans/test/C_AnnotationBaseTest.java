package com.jdc.beans.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class C_AnnotationBaseTest {

	@Test
	void test() {
		try (var context = new AnnotationConfigApplicationContext("com.jdc.annotations")) {

			var client = context.getBean("client");
			var config = context.getBean("myClientService");

			assertNotNull(client);
			assertNotNull(config);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
