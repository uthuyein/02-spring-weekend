package com.jdc.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.beans.Messages;

public class A_XmlBaseTest {
	
	@Test
	@Disabled
	void classpathXmlApplicationContextTest() {
		var context = new ClassPathXmlApplicationContext("classpath:context.xml");
		context.refresh();
		context.refresh();
		var messages = context.getBean(Messages.class);
		
		messages.setMessage("Hello classpath xml");
		System.out.println(messages.getMessage());
		
	}
	
	@Test
	void fileSystemXmlApplicationContextTest() {
		var context = new FileSystemXmlApplicationContext("file:context.xml");
		context.refresh();
		context.refresh();
		var messages = context.getBean(Messages.class);
		
		messages.setMessage("Hello file path xml");
		System.out.println(messages.getMessage());
	}

	@Test
	@Disabled
	void genericSingleRefreshXmlTest() {
		var context = new GenericXmlApplicationContext("classpath:context.xml");
		//context.load("classpath:context.xml");
		//context.refresh();
		var messages = context.getBean(Messages.class);
		
		messages.setMessage("Hello");
		System.out.println(messages.getMessage());
	}
}
