package com.jdc.mkt.model.entity.product;


import com.jdc.mkt.model.entity.Product;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectProduct(
		int id,
		String name,
		String category,
		String size
		) {

	@SuppressWarnings("deprecation")
	public static void select(CriteriaQuery<SelectProduct> query, Root<Product> root) {
		
		query.multiselect(
				root.get("id"),
				root.get("name"),
				root.get("category").get("name"),
				root.get("size").get("name")
				);
	}

	public static SelectProduct selectProduct(Product p) {	
		return new SelectProduct(p.getId(),p.getName(), p.getCategory().getName(), p.getSize().getName());
	}
}
