package com.jdc.mkt.model;

import com.jdc.mkt.model.entity.Product;

import lombok.Data;

@Data
public class ShoppingCartItem {

	private Product product;
	private int qty;
	
	public void plusOne() {
		 qty ++ ;
	}
	
	public void minusOne() {
		 qty --;
	}
	
	
	
	public double getPrice() {
		return qty >= 5 ? product.getWsPrice():product.getDtPrice();
	}
}
