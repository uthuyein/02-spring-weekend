package com.jdc.mkt.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Product;
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
	
	@PostMapping("upload")
	String upload(@RequestPart MultipartFile file) {
		if(null == file) {
			return "redirect:/product";
		}
		try( var br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			
			String line = null;
			
			while(null != (line = br.readLine())) {
				var array = line.split("\t");
				var category = saveCategory(array[0]);
				var product = new Product();
				product.setName(array[1]);
				product.setCategory(category);
				product.setSize(Size.valueOf(array[2]));
				product.setDtPrice(Double.valueOf(array[3]));
				product.setWsPrice(Double.valueOf(array[4]));
				
				var p = productRepo.findByNameAndSize(product.getName(),product.getSize());
				if(null != p) {
					return "redirect:/product";
				}
				productRepo.save(product);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product";
	}
	
	Category saveCategory(String name) {
		var category = catRepo.findByName(name);
		if(null == category) {
			category = catRepo.save(new Category(name));
		}
		return category;
	}
	
	@PostMapping
	String addProduct(@Validated @ModelAttribute("productForm") ProductForm form,BindingResult result,RedirectAttributes attributes) {
		
		if(null == form) {
			return "redirect:/product/add";
		}
		if(result.hasErrors()) {
			return "products/add";
		}
		var category = saveCategory(form.getCategory());
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
