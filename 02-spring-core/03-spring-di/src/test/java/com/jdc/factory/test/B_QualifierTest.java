package com.jdc.factory.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.factory.JunitFactory;
import com.jdc.qualifier.MyClient;

public class B_QualifierTest extends JunitFactory{

	@Autowired
	MyClient client;
		
	@Test
	void test() {
		client.doSomething();	
	}
}
