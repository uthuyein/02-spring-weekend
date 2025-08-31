package com.jdc.mkt.dto;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cat_id")
	private int id;
	
	@Column(nullable = false,length = 25,unique = true)
	private String name;
	
	@ColumnDefault("true")
	private boolean active;
	
//	@OneToMany
//	//@JoinColumn(name = "category_id")
//	@JoinTable(
//			name = "j_cat_product_tbl",
//			joinColumns = {
//					@JoinColumn(name = "cat_id",referencedColumnName = "cat_id")
//			},
//			inverseJoinColumns = {
//					@JoinColumn(name = "prod_id",referencedColumnName = "id")
//			})
//	private List<Product> proudcts;
	
}
