package com.jdc.mkt;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RenderingResponse;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.jdc.mkt.controller.LegacyController;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/controller").setViewName("controllers/viewContollerMethod");	
		registry.addRedirectViewController("/controller/redirect", "/views/controllers/redirect.jsp");
		
	}
	
	@Bean
	SimpleUrlHandlerMapping handlerMapping(LegacyController legacy) {
		var map = new SimpleUrlHandlerMapping();
		map.setUrlMap(Map.of("/controller/legacy",legacy));	
		
		return map;
	}
	
	@Bean
	RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route()
				.GET("/controller/router",req -> RenderingResponse.create("controllers/functional")
						.modelAttribute("message","Using from router function")
						.build() )
				.build();
	}
}
