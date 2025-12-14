package com.jdc.mkt.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?> @Nullable [] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
		return new Class[] {
				ApplicationWebMvcConfig.class,
				ThymeleafConfig.class,
				BeanScopeConfig.class
			
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
