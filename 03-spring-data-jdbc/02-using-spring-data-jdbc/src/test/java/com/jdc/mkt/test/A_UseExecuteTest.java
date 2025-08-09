package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dao.PersonService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

//@SpringJUnitConfig(locations = "classpath:context.xml")
@SpringJUnitConfig(classes = AppConfig.class)
public class A_UseExecuteTest extends JunitFactory {

	@Autowired
	PersonService service;
	
	@Order(5)
	@Test
	@DisplayName("5.select query with PreparedStatementCreatorFactory and preparedStatementCallback")
	@Sql(scripts = "classpath:/person.sql")
	void selectCreatorTest() {
		System.out.println("Test 5");
		var res = service.selectPersonWithPerparedStatementCreator(2);		
	//	logger.printEntityTable(res,Person.class);
	}
	
	@Order(4)
	@Test
	@DisplayName("4.select query with string query and callablestatement")
	@Sql(scripts = "classpath:/person.sql")
	void selectTest() {
		var res = service.selectPersonWithCallableStatement();
		assertEquals(1, res.size());
		//logger.printEntityTable(res,Person.class);
	}

	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = 1)
	@DisplayName("3.delete query with string query and preparedStatementCallback")
	@Sql(scripts = "classpath:/person.sql")
	void deleteTest(int id) {
		var res = service.deletePersonWithPrepStement(id);
		assertEquals(1, res);

		//logger.printResultSetAsTable("select * from person_tbl");
	}

	@Order(2)
	@ParameterizedTest
	@DisplayName("2.update query with StatementCallback")
	@CsvSource(value = { "1:Snow:20", "2:Kelvin:30" }, delimiter = ':')
	//@Sql(scripts = "classpath:/person.sql")
	void updateTest(int id,String name, int age) {

		var p = new Person();
		p.setId(id);
		p.setName(name);
		p.setAge(age);

		var res = service.updatePersonWithStatement(p);
		assertEquals(1, res);

		//logger.printResultSetAsTable("select * from person_tbl");
	}

	@Order(1)
	@ParameterizedTest
	@DisplayName("1.insert query with ConnectionCallback")
	@CsvSource(value = { "Sophia:20:MONDAY", "Smith:30:WEDNESDAY" }, delimiter = ':')
	@Sql(scripts = "classpath:/person.sql")
	void insertTest(String name, int age, String day) {

		var p = new Person();
		p.setName(name);
		p.setAge(age);

		if (null != day) {
			p.setDay(Days.valueOf(day));
		}
		var res = service.savePersonWithConnection(p);
		assertEquals(1, res);

		//logger.printResultSetAsTable("select * from person_tbl");
	}
}
