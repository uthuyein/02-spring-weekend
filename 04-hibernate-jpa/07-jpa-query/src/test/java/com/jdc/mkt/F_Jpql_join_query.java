package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.utils.JpaFactory;

public class F_Jpql_join_query extends JpaFactory{

	@Test
	@Disabled
	void toManyTest() {
		/*
		 * select * from category_tbl c join product_tbl p on p.category_id = c.id
		 * where p.name = ?
		 */
		
		var query = em.createQuery("""
				select c from Category c join c.products p 
				where p.name = :name
				""",Category.class);
		query.setParameter("name","iPhone 15 Pro" );
		assertEquals(1, query.getResultList().size());
	}
	@Test
	void toOneTest() {
		var query = em.createQuery("""
				select p from Product p  join p.category c
				where c.name = :name
				""",Product.class);
		query.setParameter("name","Electronics" );
		assertEquals(2, query.getResultList().size());
	}
}
