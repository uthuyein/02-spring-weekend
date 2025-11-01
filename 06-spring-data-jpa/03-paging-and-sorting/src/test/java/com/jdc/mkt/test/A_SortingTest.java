package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.jdc.mkt.model.repo.ProductRepo;


@SpringBootTest
public class A_SortingTest {

	@Autowired
	private ProductRepo repo;
	

	@Test
	void selectProductByNameLikeWithAnd() {
		var sortName = Sort.by("name").ascending();
		var sortPrice = Sort.by("dtPrice").descending();
		var list = repo.findProductCategory("Diary",sortName.and(sortPrice) );
		System.out.println(list);
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {"name","dtPrice"})
	void selectProductByNameLikeWith(String s) {
		var sort = Sort.by(Order.desc(s));
		var list = repo.findProductCategory("Diary",sort );
		System.out.println(list);
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {"name","dtPrice"})
	void selectProductByNameLikeWithOrder(String s) {
		var sort = Sort.by(Order.desc(s));
		var list = repo.findProductByNameLikeIgnoreCase("a".concat("%"),sort );
		System.out.println(list);
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {"name","dtPrice"})
	void selectProductByNameLikeWithSortByAndDir(String s) {	
		var dir = Direction.DESC;
		var sort = Sort.by(dir,s);
		var list = repo.findProductByNameLikeIgnoreCase("a".concat("%"),sort );
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void selectProductByCName() {
		var list = repo.findProductByCategoryNameOrderByDtPrice("Diary");
		System.out.println(list);
	}
}
