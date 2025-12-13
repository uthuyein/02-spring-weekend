package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.product.ProductForm;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	
	@GetMapping
	String index() {
		return "products/product-list";
	}
	
	@GetMapping("/product-form")
	String addForm(@ModelAttribute ProductForm  productForm, ModelMap map) {
		return "products/product-add";
	}
	

	@PostMapping
	String save(@Validated @ModelAttribute ProductForm form,BindingResult result) {
		if(result.hasErrors()) {
			return "products/product-add";
		}
		return "redirect:/product";
	}
	

}
