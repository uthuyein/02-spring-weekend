package com.jdc.mkt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Product.Size;
import com.jdc.mkt.model.input.ProductForm;
import com.jdc.mkt.model.output.ProductInfo;
import com.jdc.mkt.model.repo.CategoryRepo;
import com.jdc.mkt.model.repo.ProductRepo;

@Controller
@RequestMapping("product")
public class ProductController {

   
	@Autowired
    private  ProductRepo productRepo;
	@Autowired
	private CategoryRepo catRepo;

	@GetMapping
	String index() {
		return "/products/list";
	}
	
	@GetMapping("edit/{id}")
	String edit(@PathVariable(required = false) Integer id,@ModelAttribute ProductForm productForm) {
		return "/products/add";
	}
	
	@GetMapping("add")
	String product() {
		return "/products/add";
	}
	
	@PostMapping
	String addProduct(@Validated @ModelAttribute("productForm") ProductForm form,BindingResult result,RedirectAttributes attributes) {
		
		if(null == form) {
			return "redirect:/product/add";
		}
		if(result.hasErrors()) {
			return "products/add";
		}
		var category = catRepo.findByName(form.getCategory());
		if(null == category) {
			category = catRepo.save(new Category(form.getCategory()));
		}
		productRepo.save(form.entity(category));
		attributes.addFlashAttribute("message", "%s has successfully save !".formatted(form.getName()));
		
		return "redirect:/product/add";
	}
	
	@ModelAttribute("products")
	List<ProductInfo> getProducts(){
		var list = productRepo.findAll().stream().map(ProductInfo::new).toList();
		return list ;
	}
	
	@ModelAttribute("sizes")
	Size[] size() {
		return Size.values();
	}
	
	@ModelAttribute("productForm")
	ProductForm productForm(@PathVariable(required = false) Integer id) {
		return null == id ? new ProductForm():productRepo.findById(id).map(ProductForm::from).orElse(new ProductForm());
	}
}
