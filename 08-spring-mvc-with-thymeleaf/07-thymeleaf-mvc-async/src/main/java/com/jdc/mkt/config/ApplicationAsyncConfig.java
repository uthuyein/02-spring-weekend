package com.jdc.mkt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.mkt.interceptors.CustomCallableInterceptor;

@Configuration
public class ApplicationAsyncConfig {

	@Bean
	CustomCallableInterceptor callableInterceptor() {
		return new CustomCallableInterceptor();
	}
}
