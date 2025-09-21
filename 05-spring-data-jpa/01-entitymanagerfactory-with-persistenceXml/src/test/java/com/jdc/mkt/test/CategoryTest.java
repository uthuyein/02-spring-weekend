package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.service.CategoryService;

@SpringJUnitConfig(classes = AppConfig.class)
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
