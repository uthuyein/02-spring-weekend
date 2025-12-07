package com.jdc.mkt.model.entity;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.model.utils.Card;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_tbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	@ColumnDefault("1")
	private boolean active;
	
	@Enumerated(EnumType.STRING)
	private Card card;
	
	
	public Customer() {
		this.name = "Guest";
	}
}
