package com.jdc.mkt.model.entity.sale;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.jdc.mkt.model.entity.Product;

import lombok.Data;

@Data
public class ProductSaleForm {

	private UUID id;
	private Product product;
	private double price;
	
	private LocalDate createDate;
	private LocalTime createTime;

}
