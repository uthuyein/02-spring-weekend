package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.entity.search.SearchByPNameLikeAndDtPrice;
import com.jdc.mkt.service.ProductService;

@SpringBootTest
public class C_ProductDynamicSearchTest {
	
	@Autowired
	private ProductService service;

	//select product by dtprice between 1000 and 2000
	//select product by name like 'a'
	//select product by dtprice equal wsprice
	
	
	@Test
	void searchBy() {
		var list = service.searchBy(new SearchByPNameLikeAndDtPrice("Diary","m", 0, 0));
		System.out.println(list);
	}
	
	
}
