package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.entity.listener.EnableTimeListener;
import com.jdc.mkt.entity.listener.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@NoArgsConstructor
@Table(name = "category_tbl")
//@EntityListeners(TimesListener.class)
@ExcludeDefaultListeners
public class Category implements EnableTimeListener{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	
	@ColumnDefault("true")
	private boolean active;
	
	@Embedded
	private Times times;
	
	@OneToMany(mappedBy = "category",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	//@JoinColumn(name = "category_id")
	private List<Product> products;
	
	public Category(String name) {
		this.name = name;
		products =  new ArrayList<Product>();
	}
	
	public void addProduct(Product... products) {
		
		for(Product p :products) {
			p.setCategory(this);
			this.products.add(p);
		}
		
	}
}
