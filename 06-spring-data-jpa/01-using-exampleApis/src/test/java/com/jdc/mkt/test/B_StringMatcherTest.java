package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.repo.ProductRepo;

@SpringBootTest
public class B_StringMatcherTest {

	@Autowired
	private ProductRepo repo;
	
	@Test
	void withStringMatcher() {
		var p = new Product();
		p.setName("iPhone".toLowerCase());
		p.setWsPrice(1199.00);
		
		var matcher = ExampleMatcher.matching()
					 .withIgnoreNullValues()
					 .withIgnorePaths("dtPrice","wsPrice","active","id")
					 .withIgnoreCase("name")
					 .withStringMatcher(StringMatcher.CONTAINING);
		
		var example = Example.of(p,matcher);
		System.out.println(repo.findAll(example));
					 
	}
}
