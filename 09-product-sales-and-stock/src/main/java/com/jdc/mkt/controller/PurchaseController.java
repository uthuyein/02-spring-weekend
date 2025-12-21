package com.jdc.mkt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.Supplier;
import com.jdc.mkt.model.entity.product.SelectProduct;
import com.jdc.mkt.model.entity.purchase.PurchaseForm;
import com.jdc.mkt.model.entity.purchase.SupplierForm;
import com.jdc.mkt.model.service.PurchaseService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService service;
	
	@GetMapping
	String index() {
		return "purchases/purchase-list";
	}
	
	@PostMapping("/supplier")
	String saveCategory(@ModelAttribute("supplierForm") SupplierForm form,String redirectUrl) {		
		service.saveSupplier(form);	
		return "redirect:"+redirectUrl;
	}
	
	@GetMapping("form")
	String addForm(@ModelAttribute PurchaseForm purchaseForm,ModelMap map) {
		return "purchases/purchase-add";
	}
	
	@ModelAttribute("supplierForm")
	SupplierForm supplierForm() {
		return new SupplierForm();
	}
	
	@ModelAttribute("suppliers")
	List<Supplier> suppliers(){
		return service.findAll();
	}
	
	@ModelAttribute("products")
	List<SelectProduct> products(){
		return service.products().stream().map(SelectProduct :: selectProduct).toList();
	}

}
