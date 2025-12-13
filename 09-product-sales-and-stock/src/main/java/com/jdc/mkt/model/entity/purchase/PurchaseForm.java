package com.jdc.mkt.model.entity.purchase;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Supplier;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseForm {

	private UUID id;
	@NotNull(message = "Please Select One Product !")
	private Product product;
	@NotNull(message = "Please Select One Supplier !")
	private Supplier supplier;
	private int qty;
	@NotEmpty(message = "Please Type Product Price !")	
	private double price;
	
	private LocalDate orderDate;
	private LocalDate issuedDate;

}
