package com.jdc.mkt.model.entity.sale;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.jdc.mkt.model.entity.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_order_tbl")
public class SaleOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	private Customer customer;
	
	private LocalDate saleDate;
	private LocalTime saleTime;
	
	
	 
}
