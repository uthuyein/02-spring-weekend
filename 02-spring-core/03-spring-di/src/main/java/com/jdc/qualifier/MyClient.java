package com.jdc.qualifier;

import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class MyClient {
	
	//@Autowired
	//@Qualifier("custom")
	private final MyService myService;
	
	public void doSomething() {
		myService.doWork();
	}
}
