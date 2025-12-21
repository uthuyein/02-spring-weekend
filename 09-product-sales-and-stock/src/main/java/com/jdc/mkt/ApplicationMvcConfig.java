package com.jdc.mkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.jdc.mkt.model.repo.BaseRepoImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass  = BaseRepoImpl.class)
@ComponentScan(basePackages = "com.jdc.mkt.controller")
public class ApplicationMvcConfig implements WebMvcConfigurer{

	@Autowired
	private LocaleChangeInterceptor interceptor;
	
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/home");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
}
