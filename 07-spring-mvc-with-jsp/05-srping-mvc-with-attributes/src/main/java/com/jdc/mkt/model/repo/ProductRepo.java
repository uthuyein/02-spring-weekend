package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Product.Size;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	Product findByNameAndSize(String name, Size size);

}
