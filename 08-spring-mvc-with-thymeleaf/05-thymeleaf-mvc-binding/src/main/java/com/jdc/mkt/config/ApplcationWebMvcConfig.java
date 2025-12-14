package com.jdc.mkt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.jdc.mkt.controller",
		"com.jdc.mkt.binding",
		"com.jdc.mkt.services"})
public class ApplcationWebMvcConfig implements WebMvcConfigurer{

	
}
