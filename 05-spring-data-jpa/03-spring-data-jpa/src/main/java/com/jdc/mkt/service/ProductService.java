package com.jdc.mkt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalInt;
import com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalQty;
import com.jdc.mkt.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public List<Product> findProductByCategoryName(String name){
		return repo.findByCategoryName(name);
	}
	
	@Transactional
	public List<Product> getProductByCategoryName(String name){
		return repo.getProductByNameLike(name.concat("%"));
	}
	
	public List<Product> findFirst3ByStartsWith(String name){
		return repo.findFirst3ByNameStartsWith(name);
	}
	
	public Long countByDtPriceLessThan(double d) {
		return repo.countProductBydtPriceLessThanEqual(d);
	}
	
	public List<SelectCNamePNameAndTotalQty> findCNamePNameWithTotalQtyByJpql(){
		return repo.selectWithCNamePNameAndQtyByJpql();
	}
	
	public List<SelectCNamePNameAndTotalQty> findCNamePNameWithTotalQtyBySql(){
		return repo.selectWithCNamePNameAndQtyBySql();
	}
	
	public List<SelectCNamePNameAndTotalInt> findCNamePNameWithTotalQtyByInt(){
		return repo.selectWithCNamePNameAndQtyByInt();
	}
	
}
