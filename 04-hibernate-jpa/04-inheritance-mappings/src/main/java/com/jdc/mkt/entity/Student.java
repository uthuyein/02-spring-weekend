package com.jdc.mkt.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("3")
public class Student extends Account{
	
	public Student() {
		 setAccountType(AccountType.STUDENT);
	}

	@ManyToOne
	private Classroom room;
}
