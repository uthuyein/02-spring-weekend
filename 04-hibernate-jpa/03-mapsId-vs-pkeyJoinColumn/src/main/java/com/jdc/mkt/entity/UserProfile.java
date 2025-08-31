package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserProfile {

	@Id
	private int id;
	private LocalDate dob;
	private Gender gender;
	private List<String> hobbies;
	
	public enum Gender{
		MALE,FEMALE,OTHER
	}
}
