package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectPNameWithDtPrice;
import com.jdc.mkt.repo.ProductRepo;

@SpringBootTest
public class D_FetchableFluentQueryTest {

	@Autowired
	private ProductRepo repo;
	
	@Test
	void usingProjectWithFindBy() {
		var prod = new Product();
		
		var matcher = ExampleMatcher.matching()
				.withIgnorePaths("id","dtPrice","wsPrice","active","category.id");
		
		var list = repo.findBy(Example.of(prod,matcher),
				q -> q.project("name","dtPrice")
				.as(SelectPNameWithDtPrice.class).all());
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void usingCountWithFindBy() {
		var prod = new Product();
		var c = new Category();
		c.setName("Books");
		prod.setCategory(c);
		
		var matcher = ExampleMatcher.matching()
				.withIgnorePaths("id","dtPrice","wsPrice","active","category.id")
				.withMatcher("category.name", m -> m.exact());
		
		var count = repo.
				findBy(Example.of(prod,matcher),
						p -> p.count());
		
		System.out.println(count);
				
	}
}
