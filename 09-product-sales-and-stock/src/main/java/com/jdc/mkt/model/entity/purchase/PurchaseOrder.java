package com.jdc.mkt.model.entity.purchase;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.mkt.model.entity.Supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_order_tbl")
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	private Supplier supplier;
	
	private LocalDate orderDate;
	private LocalDate issuedDate;
	
	
	 
}
