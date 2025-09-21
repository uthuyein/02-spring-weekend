package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.LocalContainerEntityManagerBeanConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.service.CategoryService;

@SpringJUnitConfig(classes = LocalContainerEntityManagerBeanConfig.class)
//@SpringJUnitConfig(locations = "/META-INF/appConfig-with-LEMF.xml")
public class CategoryTest {

	@Autowired
	CategoryService service;
	
	@Test
	void insertTest() {
		var c = new Category();
		c.setName("Foods");
		c.setActive(true);
		service.create(c);
	}
}
