package com.jdc.mkt.model.entity.product;

import com.jdc.mkt.model.entity.Category;

import lombok.Data;

@Data
public class CategoryForm {

	private int id;
	private String name;
	private boolean active;
	
	
	public  Category entity() {
		var cat = new Category();
		cat.setName(name);
		cat.setActive(true);
		return cat;
	}
}
