package com.jdc.test;

import org.junit.jupiter.api.Test;

import com.jdc.beans.DefaultMessages;
import com.jdc.beans.Hello;

public class HelloTest {

	@Test
	void test() {
		var hello = new Hello(new DefaultMessages());
		hello.greet();
	}
}
