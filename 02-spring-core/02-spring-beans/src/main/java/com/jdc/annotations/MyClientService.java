package com.jdc.annotations;

import org.springframework.stereotype.Component;

@Component
public class MyClientService {

	private final MyClient client;
	
	public MyClientService(MyClient client) {
		this.client = client;
	}
}
