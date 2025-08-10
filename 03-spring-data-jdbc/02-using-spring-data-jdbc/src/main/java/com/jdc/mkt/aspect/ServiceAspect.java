package com.jdc.mkt.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jdc.mkt.Logger;
import com.jdc.mkt.utils.anno.Connector;

@Aspect
@Component
@Connector(name = "testDb", user = "root", password = "admin")
public class ServiceAspect {

	@Value("${p.select}")
	private String query;
	
	static Logger logger;
	
	static {
		logger = Logger.getInstance(ServiceAspect.class);
	}
	
	@AfterReturning(value = "within(com.jdc.mkt.dao.*Service)")
	public void afterReturn() {
		logger.printResultSetAsTable(query);
		
	}
}
