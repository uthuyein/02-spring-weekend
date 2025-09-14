package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.dto.Product;

public class D_OperatorTest extends JpaFactory {

	@Test
	void inOpeTest() {
		var query = em.createQuery("select p from Product p where p.category.name in('Sports','Books')",Product.class);
		var stream = query.getResultStream();
		assertEquals(4, stream.count());
	}
}
