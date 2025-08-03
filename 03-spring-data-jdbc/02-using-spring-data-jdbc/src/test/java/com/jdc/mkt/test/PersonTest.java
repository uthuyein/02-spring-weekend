package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.dao.PersonService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

@SpringJUnitConfig(locations = "classpath:context.xml")
public class PersonTest extends JunitFactory{

	@Autowired
	PersonService service;
	
	@Order(1)
	@ParameterizedTest
	@CsvSource(value = { "Sophia:20:MONDAY", "Smith:30:WEDNESDAY" }, delimiter = ':')
	void insertTest(String name, int age, String day) {

		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		var res = service.savePerson(p);
		assertEquals(1, res);

		logger.printResultSetAsTable("select * from person_tbl");
	}
}
