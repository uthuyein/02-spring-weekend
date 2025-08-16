package com.jdc.mkt.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dao.PersonUpdateService;
import com.jdc.mkt.dto.Person;
import com.jdc.mkt.dto.Person.Days;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class C_UpdateQueryTest {

	@Autowired
	PersonUpdateService service;
	
	@Test
	@DisplayName("1.insert person_tbl")
	@Sql(scripts = {
			"classpath:/person.sql",
			"classpath:/insert.sql"
	})
	void testOne(@Value("${p.prep.insert}")String query) {
		var p = new Person();
		p.setName("Sopheia");
		p.setAge(30);
		p.setDay(Days.SUNDAY);
		var key = service.insertPersonWithCreatorAndKeyHolder(p);
		System.out.println("Primary Key :"+key);
	}
}
