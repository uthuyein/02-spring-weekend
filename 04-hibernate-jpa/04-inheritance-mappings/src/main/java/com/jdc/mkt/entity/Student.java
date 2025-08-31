package com.jdc.mkt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends Account{

	@ManyToOne
	private Classroom room;
}
