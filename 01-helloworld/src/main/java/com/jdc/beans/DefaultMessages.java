package com.jdc.beans;

public class DefaultMessages extends Messages{

	@Override
	String getMessage(String name) {
		return "This is default messages for"+name;
	}
}
