package com.jdc.mkt.model.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findProductByCategoryNameOrderByDtPrice(String name);
	
	List<Product> findProductByNameLikeIgnoreCase(String name,Sort sort);
	
	@Query("select p from Product p where p.category.name = ?1")
	List<Product> findProductCategory(String category,Sort sort);
}

