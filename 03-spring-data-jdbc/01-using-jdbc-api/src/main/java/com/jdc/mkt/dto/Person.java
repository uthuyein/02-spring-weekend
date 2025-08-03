package com.jdc.mkt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

	private int id;
	@NonNull
	private String name;
	@NonNull
	private Integer age;
	@NonNull
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
