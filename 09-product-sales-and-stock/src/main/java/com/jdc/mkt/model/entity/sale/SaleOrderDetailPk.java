package com.jdc.mkt.model.entity.sale;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SaleOrderDetailPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "sale_order_id",insertable = false,updatable = false)
	private UUID saleOrderId;
	@Column(name = "product_id",insertable = false,updatable = false)
	private int productId;
	
}
