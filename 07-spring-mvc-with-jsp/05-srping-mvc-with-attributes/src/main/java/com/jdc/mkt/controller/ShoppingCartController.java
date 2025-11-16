package com.jdc.mkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jdc.mkt.model.ShoppingCart;
import com.jdc.mkt.model.repo.ProductRepo;

@Controller
@RequestMapping("cart")
@SessionAttributes("cart")
public class ShoppingCartController {

	@Autowired
	private ProductRepo repo;

	@GetMapping("add/{id}")
	String addToCart(@PathVariable Integer id, @SessionAttribute(required = false) ShoppingCart cart) {
		
		if (null == cart) {
			return "redirect:/product";
		}
		var product = repo.findById(id).get();
		cart.addToCart(product);

		return "redirect:/product";
	}

	@ModelAttribute("cart")
	ShoppingCart shoppingCart() {
		return new ShoppingCart();
	}
}
