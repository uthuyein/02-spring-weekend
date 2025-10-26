package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.NullHandler;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repo.CategoryRepo;

@SpringBootTest
public class A_ExampleMatcherForAllPropertiesTest {

	@Autowired
	private CategoryRepo repo;
	
	@Test
	public void IgnoreCase() {
		var c = new Category();
		c.setName("electronics");
		var matcher = ExampleMatcher.matchingAny()
					//.withIgnoreNullValues()
					//.withIgnoreCase();
					//.withIgnoreCase(true);
					.withIgnoreCase("name");
		System.out.println(repo.findAll(Example.of(c,matcher)));
	}
	
	@Test
	@Disabled
	public void nullHandler() {
		var c = new Category();
		c.setName("Electronics");
		c.setActive(true);
		var matcher = ExampleMatcher.matchingAny()
					 .withNullHandler(NullHandler.IGNORE);
				    //.withIgnoreNullValues();
					//.withIncludeNullValues();
		System.out.println(repo.findAll(Example.of(c,matcher)));
	}
	
	@Test
	@Disabled
	public void findBy() {
		//Probe Obj
		var c = new Category();
		c.setName("Electronics");
		
		//Matcher Obj
		var matcher = ExampleMatcher.matching().withIgnoreCase();			
		
		//Example Obj
		var example = Example.of(c,matcher);
		
		var list =  repo.findAll(example);
		System.out.println(list);
	}
}
