package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.utils.JpaFactory;

public class A_query_vs_typedQuery extends JpaFactory{

	@Order(2)
	@ParameterizedTest
	@CsvSource(delimiter = ':',value = {
		"s:2",
		"m:1"
	})
	void typeQueryWithNameParamTest(String param,int res) {
		var query = em.createQuery("select p from Product p where lower(p.name) like lower(:name)",Product.class);
		query.setParameter("name", param.concat("%"));
		List<Product> list = query.getResultList();
		assertEquals(res, list.size());
		
	}

	
	@Order(1)
	@ParameterizedTest
	@CsvSource(delimiter = ':',value = {
		"s:2",
		"m:1"
	})
	@SuppressWarnings("unchecked")
	void queryWithIndexParamTest(String param,int res) {
		var query = em.createQuery("select p from Product p where lower(p.name) like lower(?1)");
		query.setParameter(1, param.concat("%"));
		List<Product> list = (List<Product>) query.getResultList();
		assertEquals(res, list.size());
	}
}
