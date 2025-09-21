package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.utils.JpaFactory;

public class J_Criteria_Query extends JpaFactory{
	
	@Test
	/*
	 * select * from product_tbl p 
	 * join category_tbl c on p.category_id = c.id
	 * where c.name = ?
	 */
	
	void criteriaWithPredicateByCatNameTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Product.class);
		
		var root = cq.from(Product.class);
		cq.select(root);
		
		var catName = root.get("category").get("name");
		
		var predicate = cb.equal(catName, "Electronics");
		
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(p -> System.out.println(p.getName()));
		
	}
	@Test
	@Disabled
	//select * from product_tbl where lower(name) like lower(?)
	void criteriaWithPredicateTest() {
		//Create criteria builder
		var cb = em.getCriteriaBuilder();
		
		
		//Create criteria query for Product
		var cq = cb.createQuery(Product.class);
		
		//from product_tbl
		var root = cq.from(Product.class);
		
		//select * from product_tbl
		cq.select(root);
		
		//lower(name) like lower(?)
		var predicate = cb.like(cb.lower(root.get("name")), "s".toLowerCase().concat("%"));
		
		//where lower(name) like lower(?)
		cq.where(predicate);
		var query = em.createQuery(cq);
		
		List<Product> list = query.getResultList();
		assertEquals(2, list.size());
	}

	@Test
	//@Disabled
	//select * from product_tbl
	void criteriaTest() {
		//create criteria builder
		var cb = em.getCriteriaBuilder();
		
		//create criteria query for Product(what we need)
		var cq = cb.createQuery(Product.class);
		
		//from category_tbl
		var root = cq.from(Product.class);
		//select * 
		cq.select(root);
		
		var query = em.createQuery(cq);
		
		List<Product> list = query.getResultList();
		assertEquals(8, list.size());
	}
}
