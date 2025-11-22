package com.jdc.mkt.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jdc.mkt.model.entity.Product;

import lombok.Data;

@Data
public class ShoppingCart {

	private Map<Integer, ShoppingCartItem> items = new LinkedHashMap<Integer, ShoppingCartItem>();
	
	public void addToCart(Product p) {
		var item = items.get(p.getId());
		System.out.println("Item :::"+item);
		if(null == item) {
			item = new ShoppingCartItem();
			item.setProduct(p);
			items.put(p.getId(), item);
		}
		
		item.plusOne();
		System.out.println("items ::::"+items);
	}
	
	public void removeFromCart(int id) {
		var item = items.get(id);
		
		if(null != item) {
			item.minusOne();
		}
		if(item.getQty() == 0) {
			items.remove(id);
		}
	}
	
	public int getTotalItems() {
		return items.values().stream().mapToInt(i -> i.getQty()).sum();
	}
	
	public Double getTotalItemsAmount() {
		return items.values().stream().mapToDouble(i -> i.getQty()*i.getPrice()).sum();
	}
	
	public List<ShoppingCartItem> getItems(){
		return new ArrayList<ShoppingCartItem>(items.values());
	}
}
