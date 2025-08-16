package com.jdc.mkt.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jdc.mkt.PrintLogger;
import com.jdc.mkt.utils.DatabaseType;
import com.jdc.mkt.utils.anno.Connector;

@Aspect
@Component
@Connector(database = DatabaseType.MYSQL,name = "testDb",password = "admin",user = "root")
public class ServiceAspect {

	@Value("${p.select}")
	private String query;
	
	static PrintLogger logger;
	
	static {
		logger = PrintLogger.getInstance(ServiceAspect.class);
		
	}
	
	@AfterReturning(value = "within(com.jdc.mkt.dao.*Service)")
	public void afterReturn() {
		logger.printTableByStringQuery(query);
		
	}
}
