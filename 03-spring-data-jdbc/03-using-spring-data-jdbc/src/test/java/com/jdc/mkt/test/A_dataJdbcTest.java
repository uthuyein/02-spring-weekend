package com.jdc.mkt.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;
import com.jdc.mkt.service.PersonService;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class A_dataJdbcTest {
	
	@Autowired
	PersonService service;
	
	@Order(1)
	@ParameterizedTest
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("1.insert query with spring jdbc insert")
	@CsvSource(value = { "Sophia:20:MONDAY", "Smith:30:WEDNESDAY" }, delimiter = ':')
	void testOne(String name, int age, String day) {
		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		service.insert(p);
		
	}
}
