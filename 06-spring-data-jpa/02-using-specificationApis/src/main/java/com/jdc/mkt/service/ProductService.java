package com.jdc.mkt.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.search.SearchByPNameLikeAndDtPrice;
import com.jdc.mkt.entity.select.SelectCNamePNameAndDtPrice;
import com.jdc.mkt.repo.ProductRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public List<SelectCNamePNameAndDtPrice> searchBy(SearchByPNameLikeAndDtPrice search){
		return repo.search(searchFunction(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectCNamePNameAndDtPrice>> searchFunction(SearchByPNameLikeAndDtPrice search) {
		Function<CriteriaBuilder,CriteriaQuery<SelectCNamePNameAndDtPrice>> fun = cb -> {
			
			var query = cb.createQuery(SelectCNamePNameAndDtPrice.class);
			
			var root = query.from(Product.class);
			
			SelectCNamePNameAndDtPrice.select(query,root);
			
			query.where(search.search(cb,root));
			
			return query;
		};
		
		return fun;
	}
}
