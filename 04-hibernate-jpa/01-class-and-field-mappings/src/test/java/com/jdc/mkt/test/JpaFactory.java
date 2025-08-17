package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.dto.Category;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("class-and-field-mappings");
	}
	
	@Test
	void test() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var c = new Category();
		c.setName("Foods");
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
}
