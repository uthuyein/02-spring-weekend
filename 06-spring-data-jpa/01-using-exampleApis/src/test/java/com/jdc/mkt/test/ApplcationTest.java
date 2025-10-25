package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.services.CategoryService;

@SpringBootTest
public class ApplcationTest {

	@Autowired
	private CategoryService service;
	
	@Test
	void test() {
		var c = new Category();
		c.setName("test");
		service.saveCategory(c);
	}
}
