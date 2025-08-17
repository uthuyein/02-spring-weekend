package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dao.D_SimpleJdbcInsert_UpdateService;
import com.jdc.mkt.dao.E_NamedParam_UpdateService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class D_SimpleJdbcInsertTest {
	
	@Autowired
	private D_SimpleJdbcInsert_UpdateService service;

	@Autowired
	private E_NamedParam_UpdateService names;
	
	
	@Test
	@Order(5)
	@DisplayName("5.select person_tbl using with BeanPropertyRowMapper")
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	void testFive(@Value("${p.select}") String sql) {	
		var list = names.selectWithDataClassRowMapper(sql);
		assertEquals(5, list.size());
	}
	
	@Test
	@Order(4)
	@Disabled
	@DisplayName("4.update person_tbl using with NamedParamsJdbcTemplate")
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	void testFour(@Value("${p.update.with.name.param}") String sql) {	
		var row = names.updateWithExecute(sql,"Thomas Risberg",56,2);
		assertEquals(1, row);
	}
	
	@Test
	@Order(3)
	@Disabled
	@DisplayName("3.insert person_tbl using with NamedParamsJdbcTemplate")
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	void testThree(@Value("${p.insert.with.name.param}") String sql) {
		var p = new Person();
		p.setName("Koung");
		p.setAge(30);
		p.setDay(Days.SUNDAY);
		var row = names.insertWithMap(sql, p);
		assertEquals(1, row);
	}
	
	@Test
	@Order(2)
	@Disabled
	@DisplayName("2.insert person_tbl using with simpleJdbcInsert and generate keys")
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	void testTwo() {
		var p = new Person();
		p.setName("Koung");
		p.setAge(30);
		p.setDay(Days.SUNDAY);
		var key = service.insertWithSimpleJdbcInsert(p);
		System.out.println("Primary Key :"+key);
	}

	
	@Test
	@Order(1)
	@Disabled
	@DisplayName("1.insert person_tbl using with generate keys")
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	void testOne(@Value("${p.prep.insert}")String query) {
		var p = new Person();
		p.setName("Sopheia");
		p.setAge(30);
		p.setDay(Days.SUNDAY);
		var key = service.insertWithJdbcTemplate(query, p);
		System.out.println("Primary Key :"+key);
	}

}
