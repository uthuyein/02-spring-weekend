package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dao.A_JdbcTemplate_ExecuteService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

//@SpringJUnitConfig(locations = "classpath:context.xml")
@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class A_UseExecuteTest  {

	@Autowired
	A_JdbcTemplate_ExecuteService service;
	
	@BeforeAll
	@Sql(statements = "truncate table person_tbl")
	static void init() {
		
	}
	
	@Order(5)
	@Test
	@DisplayName("5.select query with PreparedStatementCreatorFactory and preparedStatementCallback")
	void selectCreatorTest() {
		System.out.println("Test 5");
		var res = service.selectPersonWithPerparedStatementCreator(2);	
		assertEquals(1, res.size());
	}
	
	@Order(4)
	@Test
	@DisplayName("4.select query with string query and callablestatement")
	void selectTest() {
		var res = service.selectPersonWithCallableStatement();
		assertEquals(1, res.size());
	}

	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = 1)
	@DisplayName("3.delete query with string query and preparedStatementCallback")
	void deleteTest(int id) {
		var res = service.deletePersonWithPrepStement(id);
		assertEquals(1, res);
	}

	@Order(2)
	@ParameterizedTest
	@DisplayName("2.update query with StatementCallback")
	@CsvSource(value = { "1:Snow:20", "2:Kelvin:30" }, delimiter = ':')
	void updateTest(int id,String name, int age) {

		var p = new Person();
		p.setId(id);
		p.setName(name);
		p.setAge(age);

		var res = service.updatePersonWithStatement(p);
		assertEquals(1, res);
	}

	@Order(1)
	@ParameterizedTest
	@DisplayName("1.insert query with ConnectionCallback")
	@CsvSource(value = { "Sophia:20:MONDAY", "Smith:30:WEDNESDAY" }, delimiter = ':')
	void insertTest(String name, int age, String day) {

		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		var res = service.savePersonWithConnection(p);
		assertEquals(1, res);
	}
}
