package com.jdc.mkt.model.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PurchaseDetailPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "purchase_id",insertable = false,updatable = false)
	private UUID purchaseOrderId;
	@Column(name = "product_id",insertable = false,updatable = false)
	private int productId;
	
}
