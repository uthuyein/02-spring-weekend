package com.jdc.mkt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repo.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;

	public Category saveCategory(Category category) {
		return repo.save(category);
	}
}
