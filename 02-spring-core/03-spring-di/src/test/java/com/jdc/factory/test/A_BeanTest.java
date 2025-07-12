package com.jdc.factory.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.dto.MyClient;
import com.jdc.factory.JunitFactory;

public class A_BeanTest extends JunitFactory{
	
	@Autowired
	MyClient client;
	
	@Test
	void test() {
		client.doSomething();
	}

}
