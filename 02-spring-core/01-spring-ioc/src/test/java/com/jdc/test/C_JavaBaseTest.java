package com.jdc.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.Messages;
import com.jdc.config.MyConfig;

public class C_JavaBaseTest {

	@Test
	void test() {
		try (var context = new AnnotationConfigApplicationContext(MyConfig.class)) {

			var mess = context.getBean(Messages.class);
			mess.setMessage("This is Java base annotation cofig test");

			var date = context.getBean(LocalDate.class);

			System.out.println(mess.getMessage() + "\n" + date);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
