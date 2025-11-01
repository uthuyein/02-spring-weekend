package com.jdc.mkt.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Voucher voucher;
}
