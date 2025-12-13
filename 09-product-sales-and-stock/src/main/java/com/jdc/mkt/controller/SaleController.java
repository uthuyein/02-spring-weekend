package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.sale.SaleForm;

@Controller
@RequestMapping("sale")
public class SaleController {
	
	
	@GetMapping
	String index() {
		return "sales/sale-list";
	}
	
	@GetMapping("productAdd")
	String saleAdd(@ModelAttribute SaleForm saleForm,ModelMap map) {
		return "sales/sale-add";
	}
	
	@GetMapping("productList")
	String saleList(ModelMap map) {
		return "sales/sale-list";
	}
	@GetMapping("product")
	String saelProduct(@ModelAttribute SaleForm saleForm,ModelMap map) {
		return "sales/sale-product";
	}

}
