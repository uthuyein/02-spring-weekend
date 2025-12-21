package com.jdc.mkt.model.entity.purchase;

import com.jdc.mkt.model.entity.Supplier;

import lombok.Data;

@Data
public class SupplierForm {

	private int id;
	private String name;
	private boolean active;
	
	
	public  Supplier entity() {
		var sup = new Supplier();
		sup.setName(name);
		sup.setActive(true);
		return sup;
	}
}
