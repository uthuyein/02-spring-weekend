package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class A_Persist_Find_Vs_GetReference extends JpaFactory{

	@Order(1)
	@ParameterizedTest
	@CsvSource(delimiter = ':',value = {
			"Fruit:Orange:2000.00",
			"Drink:Cola:1000.00"
	})
	void persistTest(String category,String product,double price) {
		var em = emf.createEntityManager();
		
		//To Be Transient
		var cat = new Category();
		cat.setName(category);
		
		var prod = new Product();
		prod.setName(product);
		prod.setPrice(price);
		prod.setCategory(cat);
		
		em.getTransaction().begin();
		//To be managed 
		em.persist(cat);
		em.persist(prod);
		em.getTransaction().commit();
		
		em.close();
	}
	
	@Test
	@Order(2)
	void findTest() {
		var em = emf.createEntityManager();
		var prod = em.find(Product.class, 1);
		show(prod);
		em.close();
	}
	
	@Test
	@Order(2)
	void getReferenctTest() {
		var em = emf.createEntityManager();
		var prod = em.getReference(Product.class, 1);
		show(prod);
		em.close();
	}
	
	private void show(Product product) {
		System.out.println();
		System.out.println("Category :%s Product:%s Price :%s"
				.formatted(
						product.getCategory().getName(),
						product.getName(),
						product.getPrice()));
	}
	
}
