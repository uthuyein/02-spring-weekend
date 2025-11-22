package com.jdc.mkt.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Data
@Entity
public class InvoiceItem {

	@EmbeddedId
	private InvoiceItemPk id;
	
	private int qty;
	
	@ManyToOne
	@MapsId("productId")
	private Product product;
	
	@ManyToOne
	@MapsId("invoiceId")
	private Invoice invoice;
	
}
