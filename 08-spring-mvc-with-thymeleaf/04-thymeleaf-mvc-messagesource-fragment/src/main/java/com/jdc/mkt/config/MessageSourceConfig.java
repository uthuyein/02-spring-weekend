package com.jdc.mkt.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageSourceConfig {

	@Bean
	MessageSource messageSource() {
		var bean = new ResourceBundleMessageSource();
		bean.addBasenames("languages/message");
		return bean;
	}
	
	@Bean
	SessionLocaleResolver localeResolver() {
		var bean = new SessionLocaleResolver();
		return bean;
	}
	
	@Bean
	LocaleChangeInterceptor changeInterceptor() {
		var bean = new LocaleChangeInterceptor();
		bean.setParamName("lang");
		return bean;
	}
	
}
