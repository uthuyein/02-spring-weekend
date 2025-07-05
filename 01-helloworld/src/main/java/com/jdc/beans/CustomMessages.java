package com.jdc.beans;

public class CustomMessages extends Messages{

	@Override
	String getMessage(String name) {
		return "This is custom messages for "+name;
	}
}
