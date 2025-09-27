package com.jdc.mkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	public void save(Category c) {
		repo.save(c);
	}
}
