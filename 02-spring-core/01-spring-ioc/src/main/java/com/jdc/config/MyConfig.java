package com.jdc.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdc.beans.Messages;

@Configuration
@ComponentScan(basePackages = "com.jdc.config")
public class MyConfig {

	@Bean
	public Messages getMessages() {
		return new Messages();
	}
	
	@Bean
	public LocalDate getDate() {
		return LocalDate.now();
	}
}
