package com.jdc.mkt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Classroom;
import com.jdc.mkt.entity.Teacher;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	protected static EntityManagerFactory emf ;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("inheritance-mappings");
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
		
		var room = new Classroom();
		room.setName("101");
				
		var stu = new Teacher();
		stu.setName("Andrew");
		stu.setUser("aa");
		stu.setPassword("12312312");		
		//stu.setRoom(room);
		
		em.getTransaction().begin();
		em.persist(room);
		em.persist(stu);
		em.getTransaction().commit();
	}
}
