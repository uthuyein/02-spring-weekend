package com.jdc.mkt.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitialize extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?> @Nullable [] getRootConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
		return new Class<?>[] {
			ApplicationWebMvcConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {		
		return new String[] {"/"};
	}

	
}
