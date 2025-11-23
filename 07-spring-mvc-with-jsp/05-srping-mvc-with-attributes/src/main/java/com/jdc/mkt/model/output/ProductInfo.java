package com.jdc.mkt.model.output;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Product.Size;

public record ProductInfo(
		Integer id,
		String category,
		String name,
		Size size,
		Double dtPrice,
		Double wsPrice
		) {

	 public ProductInfo(Product p) {
		this(p.getId(),p.getCategory().getName(),p.getName(),p.getSize(),p.getDtPrice(),p.getWsPrice());
	}
}
