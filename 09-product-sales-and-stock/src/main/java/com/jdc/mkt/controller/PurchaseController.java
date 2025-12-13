package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.purchase.PurchaseForm;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
		
	
	
	@GetMapping
	String index() {
		return "purchases/purchase-list";
	}
	
	@GetMapping("form")
	String addForm(@ModelAttribute PurchaseForm purchaseForm,ModelMap map) {
		return "purchases/purchase-add";
	}

}
