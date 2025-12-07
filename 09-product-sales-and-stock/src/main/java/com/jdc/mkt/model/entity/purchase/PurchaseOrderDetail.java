package com.jdc.mkt.model.entity.purchase;

import com.jdc.mkt.model.entity.Product;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_order_detail_tbl")
public class PurchaseOrderDetail {

	@EmbeddedId
	private PurchaseOrderDetailPk id;
	
	@ManyToOne
	private PurchaseOrder purchaseOrder;
	@ManyToOne
	private Product product;
	
	private int qty;
	private double price;
	
}
