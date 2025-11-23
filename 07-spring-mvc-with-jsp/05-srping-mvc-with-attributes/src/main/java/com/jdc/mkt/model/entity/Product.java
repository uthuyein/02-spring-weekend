package com.jdc.mkt.model.entity;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Check(constraints = "dt_price >= ws_price")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(name = "dt_price")
	private Double dtPrice;
	@Column(name = "ws_price")
	private Double wsPrice;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	
	
	@ColumnDefault("true")
	private Boolean active;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	private Category category;
	
	
	@Getter
	public enum Size{
		SMALL(128),MEDIUM(256),LARGE(512),DEFAULT(0);
		
		private int limit;
		
		Size(int limit){
			this.limit = limit;
		}
			
	}
}
