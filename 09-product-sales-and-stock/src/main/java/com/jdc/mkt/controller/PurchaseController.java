package com.jdc.mkt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mkt.model.entity.Supplier;
import com.jdc.mkt.model.entity.product.ProductForm;
import com.jdc.mkt.model.entity.product.SelectProduct;
import com.jdc.mkt.model.entity.purchase.PurchaseForm;
import com.jdc.mkt.model.entity.purchase.SupplierForm;
import com.jdc.mkt.model.service.ProductService;
import com.jdc.mkt.model.service.PurchaseService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	
	@Autowired
	private ProductService pService;
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
	
	@PostMapping("update")
	String save(@Validated @ModelAttribute("purchaseForm") PurchaseForm form,BindingResult result,RedirectAttributes redirect) {	
		if(result.hasErrors()) {
			return "purchases/purchase-add";
		}
		
		var p =	service.savePurchase(form);
		
		if(null != p) {
			redirect.addFlashAttribute("success",p+" has uccessfully save ! ");
			
		}
		return "redirect:/product/product-form";
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
		return pService.products();
	}

}
