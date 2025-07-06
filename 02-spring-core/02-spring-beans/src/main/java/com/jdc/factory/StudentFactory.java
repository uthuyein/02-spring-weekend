package com.jdc.factory;

public class StudentFactory {

	public static Student staticFactoryMethod() {
		return new Student();
	}
	
	public Student instanceFactoryMethod() {
		return new Student();
	}
}
