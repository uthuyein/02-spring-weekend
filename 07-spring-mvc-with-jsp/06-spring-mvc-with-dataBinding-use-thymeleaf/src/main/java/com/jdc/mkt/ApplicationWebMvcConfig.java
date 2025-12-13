package com.jdc.mkt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.jdc.mkt.controller","com.jdc.mkt.binding"})
public class ApplicationWebMvcConfig implements WebMvcConfigurer{

//	@Autowired
//	private MemberConverter converter;
//	
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addConverter(converter);
//	}
}
