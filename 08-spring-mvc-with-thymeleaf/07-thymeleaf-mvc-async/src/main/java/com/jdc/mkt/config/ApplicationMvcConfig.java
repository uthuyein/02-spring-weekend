package com.jdc.mkt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.mkt.interceptors.CustomCallableInterceptor;

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = { "com.jdc.mkt.controller", "com.jdc.mkt.services" })
public class ApplicationMvcConfig implements WebMvcConfigurer{

	@Autowired
	private CustomCallableInterceptor callableInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.registerCallableInterceptors(callableInterceptor);
	}
	
}
