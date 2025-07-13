package com.jdc.qualifier;

//@Component
//@Qualifier("custom")
public class MyCustomService implements MyService {

	@Override
	public void doWork() {
		System.out.println("My Custom Service");
	}

}
