package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.dao.StatementService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

public class StatementTest {

	@ParameterizedTest
	@CsvSource({
		"Aung Aung,20,MONDAY",
		"Andrew,45,WEDNESDAY"})
	void insertTest(String name,int age,String day) {
		var p = new Person(name,age,Days.valueOf(day));
		var service = new StatementService();
		var res = service.save(p);
		assertEquals(1, res);
	}
}
