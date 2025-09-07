package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

import jakarta.persistence.PersistenceException;

public class C_State_Change extends JpaFactory {

	@Test
	@Order(3)
	void RemoveTest() {
		em.getTransaction().begin();
		
		// To Be Managed
		var c1 = em.find(Category.class, 1);
		assertTrue(em.contains(c1));

		// To Be Removed
		em.remove(c1);
		assertFalse(em.contains(c1));

		// To Be Managed
		 em.persist(c1);
		assertTrue(em.contains(c1));

		// To Be Detached
		em.detach(c1);
		assertFalse(em.contains(c1));
		
		assertThrows(IllegalArgumentException.class, () -> em.remove(c1));

		em.getTransaction().commit();
		em.close();
	}

	@Test
	@Disabled
	@Order(2)
	void MergeTest() {

		// To Be Transient
		var c1 = new Category("Snacks");
		c1.addProduct(new Product("Gar Gar", 2200.00), new Product("Oishi", 2000.00), new Product("Pop Corn", 3000.00));

		em.getTransaction().begin();

		// To Be Managed
		var c2 = em.merge(c1);
		assertTrue(em.contains(c2));

		// To Be Detached
		em.detach(c2);
		assertFalse(em.contains(c2));

		// To Be Managed
		var c3 = em.merge(c2);
		assertTrue(em.contains(c3));

		// To Be Removed
		em.remove(c3);
		assertFalse(em.contains(c3));

		assertThrows(IllegalArgumentException.class, () -> em.merge(c3));

		em.getTransaction().commit();
		em.close();
	}

	@Test
	@Disabled
	@Order(1)
	void persistTest() {
		em.getTransaction().begin();

		// To Be Transient
		var c1 = new Category("Snacks");
		c1.addProduct(new Product("Gar Gar", 2200.00), new Product("Oishi", 2000.00), new Product("Pop Corn", 3000.00));

		// To Be Managed
		em.persist(c1);
		assertTrue(em.contains(c1));

		// To Be Removed
		em.remove(c1);
		assertFalse(em.contains(c1));

		// To Be Managed
		em.persist(c1);
		assertTrue(em.contains(c1));

		// To be Detached
		em.detach(c1);
		assertFalse(em.contains(c1));

		assertThrows(PersistenceException.class, () -> em.persist(c1));

		em.getTransaction().commit();
	}
}
