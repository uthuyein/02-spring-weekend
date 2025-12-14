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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mkt.model.entity.product.CategoryForm;
import com.jdc.mkt.model.entity.product.ProductForm;
import com.jdc.mkt.model.entity.product.SizeForm;
import com.jdc.mkt.model.repo.CategoryRepo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private CategoryRepo repo;
	
	
	
	@GetMapping
	String index() {
		return "products/product-list";
	}
	
	@GetMapping("/product-form")
	String addForm(@ModelAttribute ProductForm  productForm, ModelMap map) {
		return "products/product-add";
	}
	
	@GetMapping("/category")
	String saveCategory(@RequestParam String redirectUrl,  @ModelAttribute CategoryForm categoryForm) {	
		System.out.println("test::::::          "+categoryForm);
		System.out.println("Test :::::      "+redirectUrl);
		return "redirect:/"+redirectUrl;
	}
	
	@GetMapping("/size")
	String saveSize(@RequestParam String redirectUrl,  @ModelAttribute SizeForm sizeForm) {	
		return "redirect:"+redirectUrl;
	}

	@PostMapping
	String save(@Validated @ModelAttribute ProductForm productForm,BindingResult result,RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "products/product-add";
		}
		redirect.addFlashAttribute("success", "Successfully save product !");
		return "redirect:/product";
	}
	

}
