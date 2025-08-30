package com.jdc.mkt.dto;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
@Check(constraints = "dt_price >= ws_price")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "varchar(25) check(char_length(name) >= 5) default 'No Name'")
	private String name;
	
	private double dt_price;
	private double ws_price;
	
	@ColumnDefault("true")
	private boolean active;
	
	@ManyToOne
	private Category category;
}
