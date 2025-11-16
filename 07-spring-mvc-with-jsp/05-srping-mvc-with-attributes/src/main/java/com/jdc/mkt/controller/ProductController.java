package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.Product.Size;
import com.jdc.mkt.model.input.ProductForm;
import com.jdc.mkt.model.repo.ProductRepo;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
    private final ProductRepo productRepo;

    ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

	@GetMapping
	String index() {
		return "/products/list";
	}
	
	@GetMapping("add")
	String product() {
		return "/products/add";
	}
	
	@PostMapping("add")
	String addProduct(@Validated @ModelAttribute("productForm") ProductForm form,BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:/product/add";
		}
		return "/products/add";
	}
	
	@ModelAttribute("sizes")
	Size[] size() {
		return Size.values();
	}
	
	@ModelAttribute("productForm")
	ProductForm productForm() {
		return new ProductForm();
	}
}
