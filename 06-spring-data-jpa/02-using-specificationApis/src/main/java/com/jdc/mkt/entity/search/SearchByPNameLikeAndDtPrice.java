package com.jdc.mkt.entity.search;

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
		double from,
		double to
		) {

	public  Predicate[] search(CriteriaBuilder cb, Root<Product> root) {
		var params = new ArrayList<Predicate>();
		
		if(!StringUtils.isBlank(cName)) {
			cb.equal(root.get(Product_.category).get(Category_.name), cName);
		}
		
		if(!StringUtils.isBlank(pName)) {
			cb.like(cb.lower( root.get(Product_.name)), cName.concat("%"));
		}
//		
//		if(from > 0 && to > 0) {
//			cb.between(cb., null, null);
//		}
		
		return params.toArray(size -> new Predicate[size]);
	}

}
