package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.product.ProductForm;
import com.jdc.mkt.model.repo.CategoryRepo;
import com.jdc.mkt.model.repo.SizeRepo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private CategoryRepo catRepo;
	@Autowired
	private SizeRepo sizeRepo;
	
	@GetMapping
	String index() {
		return "products/product-list";
	}
	
	@GetMapping("/product-form")
	String addForm(@ModelAttribute ProductForm  productForm, ModelMap map) {
		map.put("sizes", sizeRepo.findAll());
		map.put("categories", catRepo.findAll());
		
		return "products/product-add";
	}
	

	@PostMapping
	String save(@Validated @ModelAttribute ProductForm form,BindingResult result) {
		if(result.hasErrors()) {
			return "products/product-add";
		}
		return "redirect:/product";
	}
	
//	@ModelAttribute
//	ProductForm productForm() {
//		return new ProductForm();
//	}
}
