package com.jdc.mkt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

	private int id;
	private String name;
	private Integer age;
	private Days day;
	
	public enum Days{
		SUNDAY,
		MONDAY, 
		TUESDAY,
		WEDNESDAY, 
		THURSDAY, 
		FRIDAY, 
		SATURDAY
	}
}
