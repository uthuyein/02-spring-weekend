package com.jdc.mkt.test;

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
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class D_SimpleJdbcInsertTest {
	
	@Autowired
	private D_SimpleJdbcInsert_UpdateService service;

	
	@Test
	@Order(2)
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
