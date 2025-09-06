package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class B_State_Change extends JpaFactory{

	@Test
	@Disabled
	@Order(1)
	void manageTest() {
		var em = emf.createEntityManager();
		
		//To Be Transient
		var c1 = new Category();
		c1.setId(1);
		//c1.setName("Meals");
		
		//var c2 = em.find(Category.class, 1);
		
		var p = new Product();
		p.setName("Lemon");
		p.setPrice(300);
		
		assertFalse(em.contains(p));
		
		em.getTransaction().begin();
		
		//To Be Managed
		em.persist(p);
		assertTrue(em.contains(p));
		assertFalse(em.contains(c1));
		
		//To Be Detached
		em.detach(p);
		assertFalse(em.contains(p));
		
		//To Be Managed
		p.setName("PileApple");
		p.setPrice(2000.00);
		
		var p1 = em.merge(p);
		
		assertFalse(em.contains(p));
		assertTrue(em.contains(p1));
		
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	@Test
	@Order(2)
	void removeTest() {
		var em = emf.createEntityManager();
		
		//To Be Managed
		var p = em.find(Product.class, 1);
		assertTrue(em.contains(p));
		
		
		em.getTransaction().begin();
		
		//To Be Removed
		em.remove(p);
		assertFalse(em.contains(p));
		em.getTransaction().commit();
		em.close();
	}
	
	
}
