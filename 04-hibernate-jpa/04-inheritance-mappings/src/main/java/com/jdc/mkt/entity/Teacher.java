package com.jdc.mkt.entity;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("2")
public class Teacher extends Account{
	
	public Teacher() {
		 setAccountType(AccountType.TEACHER);
	}

	@OneToMany
	@JoinColumn(name = "teacher_id")
	private List<Course> courses;
}
