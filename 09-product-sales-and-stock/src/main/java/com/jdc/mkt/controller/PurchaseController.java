package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.purchase.PurchaseForm;
import com.jdc.mkt.model.repo.CategoryRepo;
import com.jdc.mkt.model.repo.ProductRepo;
import com.jdc.mkt.model.repo.SizeRepo;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	private SizeRepo sizeRepo;
	@Autowired
	private CategoryRepo catRepo;	
	@Autowired
	private ProductRepo prodRepo;
	
	@GetMapping
	String index() {
		return "purchases/purchase-list";
	}
	
	@GetMapping("form")
	String addForm(@ModelAttribute PurchaseForm purchaseForm,ModelMap map) {
		map.put("sizes",sizeRepo.findAll());
		map.put("category", catRepo.findAll());
		map.put("products", prodRepo.findAll());
		return "purchases/purchase-add";
	}

}
