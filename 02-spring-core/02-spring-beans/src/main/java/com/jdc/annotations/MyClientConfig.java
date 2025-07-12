package com.jdc.annotations;


import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "singleton")
public class MyClientConfig {

	/*
	 * method name will be bean name
	 * @return date
	 */
	@Bean(name = {"currentDate","curDate"})
	@Scope("prototype")
	public Date getDefaultDate() {
		return new Date();
	}
}
