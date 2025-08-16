package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.PrintLogger;
import com.jdc.mkt.utils.anno.Connector;

@TestMethodOrder(OrderAnnotation.class)
@Connector(name = "testDb", user = "root", password = "admin")
public class JunitFactory {

	static PrintLogger logger;
	
	@BeforeAll
	static void init() {
		logger = PrintLogger.getInstance(StatementTest.class);
		logger.PrintTableByupdateQuery("truncate table person_tbl");
		
	}
}
