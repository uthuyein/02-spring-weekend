package com.jdc.mkt.dto;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class VoucherDetail {

	@EmbeddedId
	private VoucherDetailPk id;
	
	private int qty;
	private double subTotal;
	
	@ManyToOne
	//@JoinColumn(insertable = false,updatable = false)
	private Product product;
	@ManyToOne
	//@JoinColumn(insertable = false,updatable = false)
	private Voucher voucher;
}
