package com.jdc.factory.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.circular.BeanA;
import com.jdc.factory.JunitFactory;

public class C_CircularTest extends JunitFactory{

	@Autowired
	BeanA a;
	
	@Test
	void test() {
		a.doSomething();
	}
}
