package com.jdc.mkt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Circle;
import com.jdc.mkt.entity.Shape;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	protected static EntityManagerFactory emf ;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("attribute-converter");
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	@Test
	void test() {
		var em = emf.createEntityManager();		
		
		var circle = new Circle(25,"Blue");
		
		var shape = new Shape();
		shape.setCircle(circle);
		
		em.getTransaction().begin();
		em.persist(shape);
		em.getTransaction().commit();
		
		var s1 = em.find(Shape.class, 1);
		var c1 = s1.getCircle();
		System.out.println(c1.getColor());
		System.out.println(c1.getRadius());
		
		System.out.println(circle.equals(c1));
	}
}
