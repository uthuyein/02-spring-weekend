package com.jdc.mkt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByCategoryName(String name);
	
	List<Product> getProductByNameLike(String name);
	
	List<Product> findFirst3ByNameStartsWith(String name);
}
