package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.service.CategoryService;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class RepoTest {

	@Autowired
	CategoryService service;
	
	@Test
	void test() {
		var c = new Category();
		c.setName("test");
		service.save(c);
	}
}
