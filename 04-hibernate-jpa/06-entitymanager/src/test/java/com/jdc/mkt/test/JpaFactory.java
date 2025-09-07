package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.PrintLogger;
import com.jdc.mkt.utils.anno.Connector;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Connector
@TestMethodOrder(OrderAnnotation.class)
public class JpaFactory {

	static EntityManagerFactory emf;
	static PrintLogger logger;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("06-entitymanager");
		logger = PrintLogger.getInstance(JpaFactory.class);
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen())
			emf.close();
	}
	
}
