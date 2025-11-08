package com.jdc.mkt.initialize;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		var mvc = new XmlWebApplicationContext();
		mvc.setConfigLocation("/WEB-INF/mvc-config.xml");
		return mvc;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		var root = new XmlWebApplicationContext();
		root.setConfigLocation("/WEB-INF/root-config.xml");
		return root;
	}

}
