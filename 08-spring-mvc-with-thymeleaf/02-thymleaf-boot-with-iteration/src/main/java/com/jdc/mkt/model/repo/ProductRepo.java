package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
