package com.jdc.beans.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.MyClient;

public class A_XmlBaseTest {

	@Test
	void test() {
		try (var context = new GenericXmlApplicationContext("classpath:context.xml")) {
			var client = context.getBean("client");
			((MyClient) client).doWork();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
