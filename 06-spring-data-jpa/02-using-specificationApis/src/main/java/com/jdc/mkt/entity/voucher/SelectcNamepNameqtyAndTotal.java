package com.jdc.mkt.entity.voucher;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.entity.Voucher;
import com.jdc.mkt.entity.VoucherDetail;
import com.jdc.mkt.entity.VoucherDetail_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public record SelectcNamepNameqtyAndTotal(
		String category,
		String product,
		int qty,
		double total
		) {

	public static void select(CriteriaQuery<SelectcNamepNameqtyAndTotal> query,Root<Voucher> root,Join<Voucher, VoucherDetail> vd) {
		
		query.multiselect(
				vd.get(VoucherDetail_.product).get(Product_.category).get(Category_.name),
				vd.get(VoucherDetail_.product).get(Product_.name),
				vd.get(VoucherDetail_.qty),
				vd.get(VoucherDetail_.subTotal)			
				);
	}
}
