package com.jdc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyClient implements InitializingBean,DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Call afterPropertiesSet method");
	}
	
	@PostConstruct
	public void create() {
		System.out.println("Call PostContstuct create method from jsr-250");
	}
	
	public void initMethod() {
		System.out.println("Call initMethod");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Call preDestroy method from jsr-250");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Call destroy method from disposablebean");
	}
	
	public void xmlDestroy() {
		System.out.println("Call xmlDestory method");
	}

}
