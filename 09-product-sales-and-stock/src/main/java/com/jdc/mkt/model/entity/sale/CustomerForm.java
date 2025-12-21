package com.jdc.mkt.model.entity.sale;

import com.jdc.mkt.model.entity.Customer;
import com.jdc.mkt.model.utils.Card;

import lombok.Data;

@Data
public class CustomerForm {

	private int id;
	private String name;
	private boolean active;
	
	
	public  Customer entity() {
		var sup = new Customer();
		sup.setName(name);
		sup.setCard(Card.Default);
		sup.setActive(true);
		return sup;
	}
}
