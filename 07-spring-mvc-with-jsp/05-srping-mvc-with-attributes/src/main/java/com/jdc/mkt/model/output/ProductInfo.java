package com.jdc.mkt.model.output;

import com.jdc.mkt.model.entity.Product;

public record ProductInfo(
		Integer id,
		String category,
		String name,
		Double dtPrice,
		Double wsPrice
		) {

	 public ProductInfo(Product p) {
		this(p.getId(),p.getCategory().getName(),p.getName(),p.getDtPrice(),p.getWsPrice());
	}
}
