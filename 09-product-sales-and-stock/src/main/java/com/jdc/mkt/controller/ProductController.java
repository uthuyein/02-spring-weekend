package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mkt.model.entity.product.CategoryForm;
import com.jdc.mkt.model.entity.product.ProductForm;
import com.jdc.mkt.model.entity.product.SizeForm;
import com.jdc.mkt.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	String index() {
		return "products/product-list";
	}
	
	@GetMapping("/product-form")
	String addForm(@ModelAttribute ProductForm  productForm, ModelMap map) {
		return "products/product-add";
	}
	
	@PostMapping("/category")
	String saveCategory(@ModelAttribute("categoryForm") CategoryForm form,String redirectUrl) {		
		service.saveCategory(form);	
		return "redirect:"+redirectUrl;
	}
	
	@PostMapping("/size")
	String saveSize(@ModelAttribute("sizeForm")SizeForm form, @RequestParam String redirectUrl) {	
		service.saveSize(form);	
		return "redirect:"+redirectUrl;
	}
	
	@GetMapping("edit/{id}")
	String edit(@PathVariable(required = false) Integer id,@ModelAttribute ProductForm productForm) {
		return "/products/add";
	}

	@PostMapping("update")
	String save(@Validated @ModelAttribute ProductForm productForm,BindingResult result,RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return "products/product-add";
		}
		var p =	service.saveProduct(productForm);
		if(null != p) {
			redirect.addFlashAttribute("success",p.name()+" has uccessfully save ! ");
			
		}
		return "redirect:/product/product-form";
	}
	

}
