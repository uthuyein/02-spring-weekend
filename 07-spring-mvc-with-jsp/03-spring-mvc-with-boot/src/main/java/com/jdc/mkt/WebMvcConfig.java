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
		registry.addRedirectViewController("/", "/views/home.jsp");
	}
	
	@Bean
	SimpleUrlHandlerMapping handlerMapping(LegacyController legacy) {
		var map = new SimpleUrlHandlerMapping();
		map.setUrlMap(Map.of("/legacy",legacy));
		
		return map;
	}
	
	@Bean
	RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route()
				.GET("/function",req -> RenderingResponse.create("views/functional.jsp")
						.modelAttribute("message","Hello router function")
						.build() )
				.build();
	}
}
