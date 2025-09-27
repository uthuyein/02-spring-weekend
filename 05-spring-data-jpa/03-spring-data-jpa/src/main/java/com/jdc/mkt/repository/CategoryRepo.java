package com.jdc.mkt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
