package com.jdc.mkt;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class InternalizationMessageConfig {

	@Bean
	MessageSource messageSource() {
		var bean = new ResourceBundleMessageSource();
		bean.setBasename("app-labels");
		return bean;
	}
}
