package com.jdc.mkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mkt.model.repo.InvoiceRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("invoice")
@RequiredArgsConstructor
public class InvoiceController {
	
	private final InvoiceRepo repo;

	@GetMapping
	String index(ModelMap map) {
		map.put("invList", repo.findAll());
		System.out.println("list" + repo.findAll());
		return "vouchers/list";
	}
	
	@ModelAttribute("counts")
	Integer totalCount() {
		return repo.findAll().stream().mapToInt(i -> i.getTotalCount()).sum();
	}
	
	@ModelAttribute("amounts")
	Double totalAmount() {
		return repo.findAll().stream().mapToDouble(i -> i.getTotalAmount()).sum();
	}
}
