package com.jdc.mkt.config;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?> @Nullable [] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
		return new Class[] {
				ApplicationMvcConfig.class,
				ApplicationThymeleafConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	

}
