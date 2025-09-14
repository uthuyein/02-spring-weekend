package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_tbl")
public class Contact {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@Column(length = 45,unique = true)
	private String email;
	@Column(length = 12,unique = true)
	private String primaryPhone;
	@Column(length = 12,unique = true)
	private String secondaryPhone;
	
	@OneToOne(fetch = FetchType.EAGER,optional = false)
	private Customer customer;
}
