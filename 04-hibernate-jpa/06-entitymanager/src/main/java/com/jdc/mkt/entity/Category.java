package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	
	@ColumnDefault("true")
	private boolean active;
	
	@OneToMany(mappedBy = "category" ,orphanRemoval = true,cascade = CascadeType.PERSIST)
	private List<Product> products =  new ArrayList<Product>();
	
	public void addProduct(Product product) {
		product.setCategory(this);
		products.add(product);
	}
}
