package com.jdc.mkt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.entity.Customer;
import com.jdc.mkt.model.entity.sale.CustomerForm;
import com.jdc.mkt.model.entity.sale.SaleForm;
import com.jdc.mkt.model.service.SaleService;

@Controller
@RequestMapping("sale")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	String index() {
		return "sales/sale-list";
	}
	
	@PostMapping("/customer")
	String saveCategory(@ModelAttribute("customerForm") CustomerForm form,String redirectUrl) {		
		service.saveCustomer(form);	
		return "redirect:"+redirectUrl;
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
	String saleProduct(@ModelAttribute SaleForm saleForm,ModelMap map) {
		return "sales/sale-product";
	}
	
	@ModelAttribute("customers")
	List<Customer> customers(){
		return service.findAll();
	}
	@ModelAttribute("customerForm")
	CustomerForm customerForm() {
		return new CustomerForm();
	}
	

}
