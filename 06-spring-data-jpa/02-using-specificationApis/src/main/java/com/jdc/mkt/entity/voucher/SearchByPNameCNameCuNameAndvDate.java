package com.jdc.mkt.entity.voucher;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Customer_;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.entity.Voucher;
import com.jdc.mkt.entity.VoucherDetail;
import com.jdc.mkt.entity.VoucherDetail_;
import com.jdc.mkt.entity.Voucher_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchByPNameCNameCuNameAndvDate(
		String pName,
		String cName,
		String cUName,
		String fromDt,
		String toDt
		) {

	public Predicate[] search(CriteriaBuilder cb ,Root<Voucher> root,Join<Voucher, VoucherDetail> vd) {
		var params = new ArrayList<Predicate>();
		
		if(StringUtils.hasText(pName)) {
			params.add(cb.like(cb.lower(vd.get(VoucherDetail_.product)
					.get(Product_.name)), pName.toLowerCase().concat("%")));
		}
		
		if(StringUtils.hasText(cName)) {
			params.add(cb.equal(vd.get(VoucherDetail_.product)
					.get(Product_.category)
					.get(Category_.name), cName));
		}
		
		if(StringUtils.hasText(cUName)) {
			params.add(cb.equal(
					root.get(Voucher_.customer)
					.get(Customer_.name), cUName));
		}
		
		if(StringUtils.hasText(fromDt)) {
			LocalDate dt = LocalDate.parse(fromDt);
			params.add(cb.greaterThanOrEqualTo(root.get(Voucher_.saleDate), dt));
		}
		
		if(toDt != null) {
			LocalDate dt = LocalDate.parse(toDt);
			params.add(cb.lessThanOrEqualTo(root.get(Voucher_.saleDate), dt));
		}
		
		return params.toArray(s -> new Predicate[s]);
	}
}
