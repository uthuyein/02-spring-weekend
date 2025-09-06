package com.jdc.mkt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Circle{

	private double radius;
	private String color;
	
	
	@Override
	public String toString() {
		return radius+":"+color;
	}

	
	
}
