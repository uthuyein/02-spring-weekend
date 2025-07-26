package com.jdc.interType;

import com.jdc.utils.ShowLogger;

public class MyServiceImpl implements MyService {

	@Override
	public void doSomething() {
		ShowLogger.output("Do Something from MyService implementation !");
	}

}
