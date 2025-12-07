package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.model.entity.Product;

public interface ProductRepo extends JpaRepositoryImplementation<Product, Integer>{

}
