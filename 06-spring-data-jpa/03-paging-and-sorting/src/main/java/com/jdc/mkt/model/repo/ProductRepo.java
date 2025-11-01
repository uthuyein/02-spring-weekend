package com.jdc.mkt.model.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	//Sorting
	List<Product> findProductByCategoryNameOrderByDtPrice(String name);
	
	List<Product> findProductByNameLikeIgnoreCase(String name,Sort sort);
	
	@Query("select p from Product p where p.category.name = ?1")
	List<Product> findProductCategory(String category,Sort sort);
	
	
	//Paging
	Page<Product> findProductByActive(Pageable pageable,boolean active);
	
	@Query(countQuery = "select count(p) from Product p where p.category.name = :name",
			value = "select p from Product p where p.category.name = :name")
	Page<Product>findAllProductByCatName(@Param("name") String name,Pageable pagable);

}

