package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;

import jakarta.persistence.EntityNotFoundException;

public class A_Persist_Find_Vs_GetReference extends JpaFactory{

	@Order(1)
	@Test
	void persistTest() {
		var em = emf.createEntityManager();
		
		//To Be Transient
//		var cat = new Category();
//		cat.setName("Snacks");
//		cat.addProduct(new Product("GarGar",2000.0));
//		cat.addProduct(new Product("AA BB",1500.0));
//		cat.addProduct(new Product("RRw ",1000.0));
		
		
		em.getTransaction().begin();
		
		//To be managed 
		//em.persist(cat);
		//em.persist(prod);
		em.getTransaction().commit();
		
		em.close();
	}
	
	@Test
	@Disabled
	@Order(2)
	void findTest() {
		var em = emf.createEntityManager();
		var prod = em.find(Product.class, 7);
		assertNull(prod);
		em.close();
		//show(prod);
		
	}
	
	@Test
	@Disabled
	@Order(2)
	void getReferenctTest() {
		var em = emf.createEntityManager();
		var prod = em.getReference(Product.class, 7);
		assertNotNull(prod);
		assertThrows(EntityNotFoundException.class, 
				() -> show(prod));
		
		em.close();
		
	}
	
	private void show(Product product) {
		System.out.println();
		System.out.println("Category :%s Product:%s Price :%s"
				.formatted(
					//	product.getCategory().getName(),
						product.getName(),
						product.getPrice()));
	}
	
}
