package com.jdc.mkt.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table("person_tbl")
public class Person {

	@Id
	private int id;
	private String name;
	private Integer age;
	private Days days;
	
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
