package com.jdc.mkt.model.entity.purchase;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Supplier;

import lombok.Data;

@Data
public class PurchaseForm {

	private UUID id;
	private Product product;
	private Supplier supplier;
	private int qty;
	private double price;
	
	private LocalDate orderDate;
	private LocalDate issuedDate;

}
