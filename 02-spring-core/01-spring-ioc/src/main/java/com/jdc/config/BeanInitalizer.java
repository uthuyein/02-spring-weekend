package com.jdc.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanInitalizer implements InitializingBean,DisposableBean{

  
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("properties");
	}
	
	@PostConstruct
	public void create() {
		System.out.println("create post construct");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("call destory method");
	}
	
	@PreDestroy
	public void preDestry() {
		System.out.println("call pre_destroy method");
	}

}
