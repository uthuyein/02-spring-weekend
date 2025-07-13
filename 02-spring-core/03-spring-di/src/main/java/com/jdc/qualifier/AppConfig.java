package com.jdc.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	MyClient myClient(
			//@Qualifier("custom") 
			MyService myService) {		
		return new MyClient(myService);
	}
	
	//@Bean(autowireCandidate = false)
	//@Qualifier("custom")
	//@Primary
	@Bean
	MyService myService() {
		return new MyCustomService();
	}
	
	@Bean
	//@Qualifier("default")
	MyService myDefault() {
		return new MyDefaultService();
	}
}
