package com.jdc.beans;

public class Hello implements Greeting {

	private Messages messages ;
	
	public Hello(Messages messages) {
		this.messages = messages;
	}
	
	@Override
	public void greet() {
		var message = messages.getMessage("John");
		System.out.println(message);
	}
}
