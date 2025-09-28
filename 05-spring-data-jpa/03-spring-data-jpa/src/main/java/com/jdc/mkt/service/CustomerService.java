package com.jdc.mkt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer.MemberType;
import com.jdc.mkt.repository.CustomerRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	private CustomerRepo repo;
		
	public List<Customer> findCustomerByContactEmail(String name){
		return repo.findCustomerByContactEmail(name);
	}
	
	public List<Customer> findByEmailWithJpql(String name){
		return repo.findByEmail(name);
	}
	
	public List<String> findByContact(String phone){
		return repo.findByContact(phone);
	}
	
	public List<Customer> findByName(String name){
		return repo.findWithName(name.concat("%"));
	}
	
	public List<Customer> findWithMemberType(MemberType type){
		return repo.findWithMember(type);
	}
}
