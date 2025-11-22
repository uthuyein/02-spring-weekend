package com.jdc.mkt.model.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class InvoiceItemPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UUID invoiceId;
	private Integer productId;
	

}
