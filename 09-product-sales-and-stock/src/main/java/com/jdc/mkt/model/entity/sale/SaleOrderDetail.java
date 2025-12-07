package com.jdc.mkt.model.entity.sale;

import com.jdc.mkt.model.entity.Product;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_order_detail_tbl")
public class SaleOrderDetail {

	@EmbeddedId
	private SaleOrderDetailPk id;
	
	@ManyToOne
	private SaleOrder saleOrder;
	@ManyToOne
	private Product product;
	
	private int qty;
	private double price;
	
}
