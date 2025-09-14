package com.jdc.mkt;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.dto.Category;
import com.jdc.mkt.dto.Contact;
import com.jdc.mkt.dto.Product;

public class E_Join_Query extends JpaFactory{

	//@Test
	@Order(1)
	void OneToOneTest() {
		var contact = em.find(Contact.class, 1);
		System.out.println(contact.getEmail());
	}
	
	//@Test
	@Order(2)
	void ManyToOneTest() {
		var product = em.find(Product.class, 1);
		System.out.println(product.getDtPrice());
	}
	
	@Test
	@Order(3)
	void OneToManyTest() {
		var cat = em.find(Category.class, 1);
		System.out.println(cat.getName());
	}
}
