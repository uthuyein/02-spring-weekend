package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.dao.StatementService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

public class StatementTest extends JunitFactory{

	static StatementService service = new StatementService();
	
	@Order(2)
	@ParameterizedTest
	@CsvSource(value = { 
			"a:::2", 
			":45::1", 
			"Aung Aung:20::1" }, delimiter = ':')
	void selectTest(String name, Integer age, String day, int res) {
		var p = new Person();
	
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		var list = service.select(p);
		assertEquals(res, list.size());
	}

	@Order(1)
	@ParameterizedTest
	@CsvSource(value = { "Aung Aung:20:MONDAY", "Andrew:45:WEDNESDAY" }, delimiter = ':')
	void insertTest(String name, int age, String day) {

		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		var res = service.save(p);
		assertEquals(1, res);

		logger.printTableByStringQuery("select * from person_tbl");
	}
}
