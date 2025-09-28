package com.jdc.mkt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "voucher_detail_tbl")
public class VoucherDetail {

	@EmbeddedId
	private VoucherDetailPk id;
	
	private int qty;
	private double subTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@MapsId("productId")
	//@JoinColumn(insertable = false,updatable = false)
	private Product product;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@MapsId("voucherId")
	//@JoinColumn(insertable = false,updatable = false)
	private Voucher voucher;
}
