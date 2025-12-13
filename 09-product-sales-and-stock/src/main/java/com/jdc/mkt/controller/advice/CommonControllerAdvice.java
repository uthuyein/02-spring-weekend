package com.jdc.mkt.controller.advice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Size;
import com.jdc.mkt.model.repo.CategoryRepo;
import com.jdc.mkt.model.repo.ProductRepo;
import com.jdc.mkt.model.repo.SizeRepo;

@ControllerAdvice
public class CommonControllerAdvice {

	@Autowired
	private CategoryRepo catRepo;
	@Autowired
	private SizeRepo sizeRepo;
	@Autowired
	private ProductRepo prodRepo;
	
	@ModelAttribute("categories")
	List<Category> categories(){
		return catRepo.findAll();
	}
	
	@ModelAttribute("sizes")
	List<Size> sizes(){
		return sizeRepo.findAll();
	}
	
	@ModelAttribute("products")
	List<Product> products(){
		return prodRepo.findAll();
	}
}
