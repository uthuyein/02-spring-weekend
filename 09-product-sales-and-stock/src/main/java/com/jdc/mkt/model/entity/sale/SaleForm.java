package com.jdc.mkt.model.entity.sale;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.jdc.mkt.model.entity.Customer;
import com.jdc.mkt.model.entity.Product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaleForm {

	private UUID id;
	@NotNull(message = "Please Select One Product  !")	
	private Product product;
	private Customer customer;
	private int qty;
	private double total;
	
	private LocalDate saleDate;
	private LocalTime saleTime;

}
