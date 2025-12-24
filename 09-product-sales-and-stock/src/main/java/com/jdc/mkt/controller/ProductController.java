package com.jdc.mkt.controller;

import java.util.List;

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
import com.jdc.mkt.model.entity.product.SelectProduct;
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
	String addForm(@ModelAttribute("productForm") ProductForm  form, ModelMap map) {
		return "products/product-add";
	}
	
	
	@GetMapping("edit/{id}")
	String edit(@PathVariable(required = false) Integer id,@ModelAttribute("productForm") ProductForm form) {
		return "/products/product-add";
	}

	@PostMapping("update")
	String save(@Validated @ModelAttribute("productForm") ProductForm form,BindingResult result,RedirectAttributes redirect) {	
		if(result.hasErrors()) {
			return "products/product-add";
		}
		
		var p =	service.saveProduct(form);
		
		if(null != p) {
			redirect.addFlashAttribute("success",p.name()+" has uccessfully save ! ");
			
		}
		return "redirect:/product/product-form";
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
	
	@ModelAttribute("products")
	List<SelectProduct> products(){
		return service.products();	
	}
	
	@ModelAttribute("productForm")
	ProductForm productForm(@PathVariable(required = false) Integer id) {
		return service.productForm(id);
	}
}
