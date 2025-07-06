package com.jdc.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyClient {

	private MyService service;
	
	public MyClient(MyService myService) {
		this.service = myService;
	}
	
	
	public void doWork() {
		service.create();
	}
	
	
}
