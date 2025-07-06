package com.jdc.beans.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.factory.Student;

public class B_XmlFactoryMethodTest {

	@ParameterizedTest
	@ValueSource(strings= {"static","instance"})
	void test(String beanName) {
		try (var context = new GenericXmlApplicationContext("classpath:context-factory.xml")) {
			Student bean =  (Student) context.getBean(beanName);
			assertNotNull(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
