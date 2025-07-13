package com.jdc.qualifier;

//@Component
//@Qualifier("default")
public class MyDefaultService implements MyService {

	@Override
	public void doWork() {
		System.out.println("My Default Service");
	}

}
