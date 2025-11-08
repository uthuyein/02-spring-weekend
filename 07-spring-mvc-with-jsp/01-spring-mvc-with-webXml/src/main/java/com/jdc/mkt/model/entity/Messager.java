package com.jdc.mkt.model.entity;

import org.springframework.stereotype.Component;

@Component
public class Messager {

	
	public String getMessage() {
		return "Message from messager bean !";
	}
}
