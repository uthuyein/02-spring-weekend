package com.jdc.mkt.model.entity.sale;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.jdc.mkt.model.entity.Product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductSaleForm {

	private UUID id;
	@NotNull(message = "Please Select One Product  !")	
	private Product product; 
	
	@NotEmpty(message = "Please Type Product Price !")	
	private double price;
	
	private LocalDate createDate;
	private LocalTime createTime;

}
