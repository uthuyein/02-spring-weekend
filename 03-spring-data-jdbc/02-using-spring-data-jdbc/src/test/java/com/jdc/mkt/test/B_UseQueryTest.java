package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.dao.PersonQueryService;

@SpringJUnitConfig(locations = "classpath:/context.xml")
public class B_UseQueryTest extends JunitFactory{

	@Autowired
	PersonQueryService service;
	
	@Value("${p.select}")
	String select;
	
	@Test
	@Order(1)
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	@DisplayName("1.select query with ResultSetExtractor")
	void testOne() {
		var list = service.selectWithResultSetExtractor(select);
		assertEquals(5, list.size());
	}
}
