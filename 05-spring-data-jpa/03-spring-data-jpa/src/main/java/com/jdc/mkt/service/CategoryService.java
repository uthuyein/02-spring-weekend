package com.jdc.mkt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	@Transactional
	public Category save(Category c) {
		return repo.save(c);
	}
	
	@Transactional
	public Category update(int id,String name) {
		Optional<Category> opt = repo.findById(id);
		var c = opt.get();
		c.setName(name);
		return repo.save(c);
	}
	
	@Transactional
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public List<Category> findAllById(int...ids){
		List<Integer> list = new ArrayList<>();
		for(int i:ids) {
			list.add(i);
		}
		return repo.findAllById(list);
	}
	
	public Long countCategory() {
		return repo.count();
	}
	
	
}
