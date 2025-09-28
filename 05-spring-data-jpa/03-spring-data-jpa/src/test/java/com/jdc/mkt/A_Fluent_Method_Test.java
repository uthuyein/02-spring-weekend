package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.service.CategoryService;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class A_Fluent_Method_Test {

	@Autowired
	CategoryService service;
	
	@Test
	@Order(1)
	void saveTest() {
		var c = new Category();
		c.setName("test");
		c = service.save(c);
		assertEquals(5, c.getId());
	}
	
	@Test
	@Order(2)
	void updateTest() {
		var c = service.update(5,"tests");
		assertEquals("tests", c.getName());
	}
	
	@Test
	@Order(3)
	void findAllByIdTest() {
		var c = new Category();
		c.setName("test");
		var list = service.findAllById(1,2,3);
		assertEquals(3, list.size());
	}
	
	@Test
	@Order(4)
	void deleteByIdTest() {
		assertThrows(
				DataIntegrityViolationException.class,
				() -> service.deleteById(1));
	}
	
	@Test
	@Order(5)
	void countTest() {
		var count = service.countCategory();
		assertEquals(5, count);
	}
}
