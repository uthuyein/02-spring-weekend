package com.jdc.mkt.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jdc.mkt.model.ShoppingCart;
import com.jdc.mkt.model.entity.Invoice;
import com.jdc.mkt.model.entity.InvoiceItem;
import com.jdc.mkt.model.entity.InvoiceItemPk;
import com.jdc.mkt.model.repo.InvoiceItemRepo;
import com.jdc.mkt.model.repo.InvoiceRepo;
import com.jdc.mkt.model.repo.ProductRepo;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("checkout")
@RequiredArgsConstructor
public class CheckoutController {

   private final ProductRepo pRepo;
   private final InvoiceRepo invRepo;
   private final InvoiceItemRepo invItemRepo;
	
	@GetMapping
	String index(@SessionAttribute(required = false,name = "cart") ShoppingCart shoppingCart) {
		if(null == shoppingCart  || shoppingCart.getItems().size() == 0){
			return "redirect:/product";
		}
		return "vouchers/cart";
	}
	
	@GetMapping("add/{id}")
	String addOne(@PathVariable Integer id,@SessionAttribute(required = false) ShoppingCart cart) {
		
		if(null == cart){
			return "redirect:/product";
		}
		
		pRepo.findById(id).ifPresent(cart::addToCart);
		
		return "vouchers/cart";
	}
	
	@GetMapping("minus/{id}")
	String minusOne(@PathVariable Integer id,@SessionAttribute(required = false) ShoppingCart cart) {
			
		if(null == cart){
			return "redirect:/product";
		}
		cart.removeFromCart(id);
			
		return "redirect:/checkout";
	}
	
	@GetMapping("checkout")
	String checkout(HttpSession session,@SessionAttribute(required = false) ShoppingCart cart) {
		
		if(null == cart) {
			return "redirect:/product";
		}
		
		var items = cart.getItems();
		var invoice = new Invoice();
		
		invoice.setIssuedDt(LocalDateTime.now());
		invoice.setTotalAmount(cart.getTotalItemsAmount());
		invoice.setTotalCount(cart.getTotalItems());
		invoice = invRepo.save(invoice);
		System.out.println("Invoice ::"+invoice);
		for(var item : items) {
			var invItem = new InvoiceItem();
			
			var pk = new InvoiceItemPk();
			pk.setInvoiceId(invoice.getId());
			pk.setProductId(item.getProduct().getId());
			
			invItem.setId(pk);
			invItem.setQty(item.getQty());
			invItem.setProduct(item.getProduct());
			invItem.setInvoice(invoice);
			invItemRepo.save(invItem);
		}
		
		 session.invalidate();
		return "redirect:/invoice";
	}
	
	@GetMapping("clear")
	String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/product";
	}
	
	
}
