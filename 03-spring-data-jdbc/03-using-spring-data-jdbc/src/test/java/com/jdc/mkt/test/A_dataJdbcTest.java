package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;
import com.jdc.mkt.service.PersonService;


@SpringBootTest
public class A_dataJdbcTest {
	
	@Autowired
	PersonService repo;
	
	@Order(1)
	@ParameterizedTest
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("1.insert query with spring jdbc insert")
	@CsvSource(value = { "Sophia:20:MONDAY:6", "Smith:30:WEDNESDAY:6" }, delimiter = ':')
	void testOne(String name, int age, String day,int id) {
		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDays(Days.valueOf(day));
		}
		p = repo.insert(p);
		assertEquals(id, p.getId());
	}
}
