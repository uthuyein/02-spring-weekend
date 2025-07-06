package com.jdc.annotations;


import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyClientConfig {

	/*
	 * method name will be bean name
	 * @return date
	 */
	@Bean(name = {"currentDate","curDate"})
	public Date getDate() {
		return new Date();
	}
}
