package com.jdc.mkt.entity.product;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectCNamePNameAndDtPrice(
		String cName,
		String pName,
		double price
		) {

	public static void select(CriteriaQuery<SelectCNamePNameAndDtPrice> query, Root<Product> root) {
		
		query.multiselect(
				root.get(Product_.category).get(Category_.name),
				root.get(Product_.name),
				root.get(Product_.dtPrice)
				);
	}

}
