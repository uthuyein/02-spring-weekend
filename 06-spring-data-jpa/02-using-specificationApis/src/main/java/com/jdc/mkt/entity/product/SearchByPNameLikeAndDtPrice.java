package com.jdc.mkt.entity.product;

import java.util.ArrayList;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchByPNameLikeAndDtPrice(
		String cName,
		String pName,
		Integer from,
		Integer to
		) {

	public  Predicate[] search(CriteriaBuilder cb, Root<Product> root) {
		var params = new ArrayList<Predicate>();
		
		if(!StringUtils.isBlank(cName)) {
			params.add(cb.equal(root.get(Product_.category).get(Category_.name), cName));
		}
		
		if(!StringUtils.isBlank(pName)) {
			params.add(cb.like(cb.lower( root.get(Product_.name)), pName.concat("%")));
		}
		
		if(from > 0 && to > 0) {
			params.add(cb.between(root.get(Product_.dtPrice), from, to));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}

}
