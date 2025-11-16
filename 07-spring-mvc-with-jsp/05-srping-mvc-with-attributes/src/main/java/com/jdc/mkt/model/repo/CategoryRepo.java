package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	Category findByName(String name);
}
