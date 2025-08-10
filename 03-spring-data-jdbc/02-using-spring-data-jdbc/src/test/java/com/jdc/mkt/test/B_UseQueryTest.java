package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dao.PersonQueryService;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class B_UseQueryTest{

	@Autowired
	PersonQueryService service;
	
	@Test
	@Order(5)
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("5.select by age between query with PreparedStatementCreator")
	void testFive() {
		var list = service.selectWithPreparedStatementCreatorByAge(20,25);
		assertEquals(3, list.size());
		
	}
	
	@Test
	@Order(4)
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("4.select by name like query with PreparedStatementCreator")
	void testFour() {
		var list = service.selectWithPreparedStatementCreatorByName("a".concat("%"));
		assertEquals(2, list.size());
		
	}
	
	@Test
	@Order(3)
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("3.select query with RowMapper")
	void testThree(@Value("${p.select}") String select) {
		var list = service.selectWithRowMapper(select);
		assertEquals(5, list.size());
		
	}
	
	@Test
	@Order(2)
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("2.select query with RowCallbackHandler")
	void testTwo(@Value("${p.select}") String select) {
		var list = service.selectWithRowCallbackHandler(select);
		assertEquals(5, list.size());
		
	}
	
	@Test
	@Order(1)
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("1.select query with ResultSetExtractor")
	void testOne(@Value("${p.select}") String select) {
		var list = service.selectWithResultSetExtractor(select);
		assertEquals(5, list.size());
		
	}
}
