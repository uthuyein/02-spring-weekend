package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.dao.PrepareStatementService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

public class PreparementStatementTest extends JunitFactory{

	static PrepareStatementService service = new PrepareStatementService();
	
	@Order(2)
	@ParameterizedTest
	@CsvSource(value = { 
			"w:::1", 
			":45::1", 
			"John:27::1" }, delimiter = ':')
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
	//@Disabled
	@ParameterizedTest
	@CsvSource(value = { "John:27:MONDAY", "William:45:WEDNESDAY" }, delimiter = ':')
	void insertTest(String name, int age, String day) {

		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		var res = service.save(p);
		assertEquals(1, res);

		logger.printResultSetAsTable("select * from person_tbl");
	}
}
