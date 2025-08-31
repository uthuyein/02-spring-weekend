package com.jdc.mkt;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.User;
import com.jdc.mkt.entity.UserProfile;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	protected static EntityManagerFactory emf ;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("pkeyJoinColumn");
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	@Test
	void test() {
//		var em = emf.createEntityManager();
//		var profile = new UserProfile();
//		profile.setId(2);
//		profile.setDob(LocalDate.now());
//		var user = new User();
//		user.setProfile(profile);
//		
//		user.setName("Andrew");
//		em.getTransaction().begin();
//		em.persist(profile);
//		em.persist(user);
//		em.getTransaction().commit();
	}
}
