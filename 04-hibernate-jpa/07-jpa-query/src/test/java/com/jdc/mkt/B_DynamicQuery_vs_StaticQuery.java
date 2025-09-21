package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.utils.JpaFactory;

public class B_DynamicQuery_vs_StaticQuery extends JpaFactory{

	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"1000.00,1500.00,2",
		"100.00,150.00,1"
	})
	void staticQueryTest(double from,double to,int res) {
		var query = em.createNamedQuery("countByProductDtPrice",Long.class);
		query.setParameter("from", from);
		query.setParameter("to", to);
		var result = query.getSingleResult();
		assertEquals(res, result);
	}
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"1000.00,1500.00,2",
		"100.00,150.00,1"
	})
	void dynamicQueryTest(double from,double to,int res) {
		var query = em.createQuery("select count(p) from Product p where dtPrice between ?1 and ?2",Long.class);
		query.setParameter(1, from);
		query.setParameter(2, to);
		var result = query.getSingleResult();
		assertEquals(res, result);
	}
}
