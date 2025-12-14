package com.jdc.mkt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.jdc.mkt.model.Counter;

@Configuration
@ComponentScan(basePackages = "com.jdc.mkt.model")
public class BeanScopeConfig {

	@Bean("requestScope")
	@Scope(scopeName = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
	Counter requsetScope() {
		return new Counter();
	}
	
	@Bean("sessionScope")
	@Scope(scopeName = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
	Counter sessionScope() {
		return new Counter();
	}
	
	@Bean("applicationScope")
	@Scope(scopeName = "application",proxyMode = ScopedProxyMode.TARGET_CLASS)
	Counter applicationScope() {
		return new Counter();
	}
}
