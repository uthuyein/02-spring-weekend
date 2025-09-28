package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.service.ProductService;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class B_Query_Method_Test {

	@Autowired
	private ProductService service;
	
	@Test
	@Order(5)
	void findCategoryByProductNameStartsWithTest() {
	}
	
	@Test
	@Disabled
	@Order(4)
	void countByDtPriceLessThanTest() {
		var count = service.countByDtPriceLessThan(100.00);
		assertEquals(5,count);
	}
	@Test
	@Disabled
	@Order(3)
	void frist3StratWithTest() {
		var list = service.findFirst3ByStartsWith("S");
		assertEquals(2,list.size());
	}
	
	@Test
	@Disabled
	@Order(2)
	void streamByProductNameTest() {
		var list = service.getProductByCategoryName("S");
		assertEquals(2,list.size());
	}
	
	@Test
	@Disabled
	@Order(1)
	void findByCategoryNameTest() {
		var list = service.findProductByCategoryName("Books");
		assertEquals(2, list.size());
	}
}
