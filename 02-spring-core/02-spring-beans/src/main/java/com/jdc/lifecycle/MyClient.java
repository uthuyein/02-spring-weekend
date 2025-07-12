package com.jdc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "singleton")
@Lazy(true)
public class MyClient implements InitializingBean,DisposableBean{

	@PostConstruct
	public void create() {
		System.out.println("Call PostContstuct create method from jsr-250");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Call afterPropertiesSet method");
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
