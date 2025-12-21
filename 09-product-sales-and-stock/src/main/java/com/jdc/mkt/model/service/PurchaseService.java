package com.jdc.mkt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Supplier;
import com.jdc.mkt.model.entity.purchase.SupplierForm;
import com.jdc.mkt.model.repo.ProductRepo;
import com.jdc.mkt.model.repo.SupplierRepo;

@Service
public class PurchaseService {

	@Autowired
	private SupplierRepo supRepo;
	@Autowired
	private ProductRepo prodRepo;
	
	public Supplier saveSupplier(SupplierForm form) {
		if(null == supRepo.findByName(form.getName())) {	
			return supRepo.save(form.entity());
		}
		return null;
	}

	public List<Supplier> findAll(){
		return supRepo.findAll();
	}
	
	public List<Product> products(){
		return prodRepo.findAll();
	}
	
	
}
