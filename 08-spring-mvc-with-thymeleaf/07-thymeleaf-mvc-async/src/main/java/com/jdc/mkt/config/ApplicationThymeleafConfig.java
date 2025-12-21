package com.jdc.mkt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
public class ApplicationThymeleafConfig {

	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var bean = new SpringResourceTemplateResolver();
		bean.setPrefix("/views/");
		bean.setSuffix(".html");
		return bean;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		var bean = new SpringTemplateEngine();
		bean.setTemplateResolver(templateResolver);
		return bean;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine engine) {
		var bean = new ThymeleafViewResolver();
		bean.setTemplateEngine(engine);
		return bean;
	}
}
