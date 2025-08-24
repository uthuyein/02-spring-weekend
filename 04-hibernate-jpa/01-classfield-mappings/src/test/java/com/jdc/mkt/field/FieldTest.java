package com.jdc.mkt.field;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.JpaFactory;

public class FieldTest extends JpaFactory{

	@Test
	void test() {
		var em = emf.createEntityManager();
//		var p1 = new PersonClass();
//		p1.setName("P1");
//		var p2 = new PersonField();
//		p2.setName("P2");
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.getTransaction().commit();
		em.close();
		
	}
}
