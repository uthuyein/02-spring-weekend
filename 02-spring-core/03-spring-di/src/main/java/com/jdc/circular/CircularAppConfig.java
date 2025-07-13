package com.jdc.circular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircularAppConfig {

	@Bean
	BeanA beanA(BeanB b) {
		return new BeanA(b);
	}
	@Bean
	BeanB beanB(BeanC c) {
		return new BeanB(c);
	}
	
	@Bean
	BeanC beanC(BeanA a) {
		return new BeanC(a);
	}
}


