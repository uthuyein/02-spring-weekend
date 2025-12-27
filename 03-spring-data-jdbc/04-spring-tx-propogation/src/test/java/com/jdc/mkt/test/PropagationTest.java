package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.Application;
import com.jdc.mkt.services.PropagationService;

@SpringJUnitConfig(classes = Application.class)
@Sql(statements = {
		"set foreign_key_checks = 0;",
		"truncate table product_tbl",
		"truncate table category_tbl",
		"set foreign_key_checks = 1;"
})
public class PropagationTest {

	@Autowired
	private PropagationService service;
	
	@ParameterizedTest
	@CsvSource("fruits,Orange,2,1,1")
	void test(String category,String product,int status,int catId,int prodId) {
		var detail = service.save(status, category, product);
		
		assertEquals(catId, detail.catId());
		assertEquals(prodId, detail.prodIds().get(0));
	}
}
