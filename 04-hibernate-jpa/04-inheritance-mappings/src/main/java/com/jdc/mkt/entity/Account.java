package com.jdc.mkt.entity;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Data;

@Data
//@MappedSuperclass
@Entity
@Inheritance
@DiscriminatorColumn(name = "child_obj",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public abstract class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable =  false,unique = true)
	private String user;
	
	@Check(constraints = "char_length(password) = 8")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	public enum AccountType{
		OFFICE,TEACHER,STUDENT
	}
}
