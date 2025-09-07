package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class D_CallBack_and_Listener extends JpaFactory{

	@Test
	@Order(1)
	void test() {
		var p1 = new Product("WW",1200.00);
		p1.setCategory(new Category("test"));
		
		em.getTransaction().begin();
		em.persist(p1);
		
		p1.setName("Waka Waka");
		var c1 = p1.getCategory();
		c1.setName("Test 2");
		
		em.getTransaction().commit();
		em.close();
		
		
	}
}
