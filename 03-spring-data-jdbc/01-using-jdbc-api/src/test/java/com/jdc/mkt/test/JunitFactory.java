package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.Logger;
import com.jdc.mkt.utils.anno.Connector;

@TestMethodOrder(OrderAnnotation.class)
@Connector(name = "testDb", user = "root", password = "admin")
public class JunitFactory {

	static Logger logger;
	
	@BeforeAll
	static void init() {
		logger = Logger.getInstance(StatementTest.class);
		logger.updateQueryAsTable("truncate table person_tbl");
		
	}
}
