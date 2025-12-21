package com.jdc.mkt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Customer;
import com.jdc.mkt.model.entity.sale.CustomerForm;
import com.jdc.mkt.model.repo.CustomerRepo;

@Service
public class SaleService {

	@Autowired
	private CustomerRepo cuRepo;
	
	public List<Customer> findAll(){
		return cuRepo.findAll();
	}
	
	public Customer saveCustomer(CustomerForm form) {
		if(null == cuRepo.findByName(form.getName())) {	
			return cuRepo.save(form.entity());
		}
		return null;
	}

	
	
	
	
}
