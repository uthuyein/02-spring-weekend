package com.jdc.annotations;

import org.springframework.stereotype.Component;

@Component
public class MyClientService {

	@SuppressWarnings("unused")
	private final MyClient client;
	
	public MyClientService(MyClient client) {
		this.client = client;
	}
}
