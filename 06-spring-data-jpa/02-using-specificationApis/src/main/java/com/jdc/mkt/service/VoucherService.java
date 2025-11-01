package com.jdc.mkt.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Voucher;
import com.jdc.mkt.entity.Voucher_;
import com.jdc.mkt.entity.voucher.SearchByPNameCNameCuNameAndvDate;
import com.jdc.mkt.entity.voucher.SelectcNamepNameqtyAndTotal;
import com.jdc.mkt.repo.VoucherRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class VoucherService {

	@Autowired
	private VoucherRepo repo;
	
	public List<SelectcNamepNameqtyAndTotal> search(SearchByPNameCNameCuNameAndvDate search){
		return repo.search(searchBy(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectcNamepNameqtyAndTotal>> searchBy(SearchByPNameCNameCuNameAndvDate search) {
		return cb ->{
			var query = cb.createQuery(SelectcNamepNameqtyAndTotal.class);
			var root = query.from(Voucher.class);
			var join = root.join(Voucher_.voucherDetails);
			
			SelectcNamepNameqtyAndTotal.select(query, root, join);
			
			query.where(search.search(cb, root, join));
			
			return query;
		};
	}
}
