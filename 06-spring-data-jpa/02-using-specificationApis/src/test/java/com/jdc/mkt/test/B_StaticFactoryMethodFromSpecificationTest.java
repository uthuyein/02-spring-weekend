package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.jdc.mkt.entity.Address_;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer_;
import com.jdc.mkt.repo.CustomerRepo;

@SpringBootTest
public class B_StaticFactoryMethodFromSpecificationTest {
	
	@Autowired
	private CustomerRepo repo;
	
	@Test
	//allof
	void selectCustomerByEmailAndTownshipAndCity() {
		Specification<Customer> spec1 = (root,cq,cb) ->	
		cb.equal(root.get(Customer_.email), "maharswe@gmail.com");
		
		Specification<Customer> spec2 = (root,cq,cb) ->	
		cb.equal(root.get(Customer_.address).get(Address_.city), "Mandalay");
		
		var list = repo.findAll(Specification.allOf(spec1,spec2));
		System.out.println(list);
		
	}

	@Test
	@Disabled
	//and
	void selectCustomerByNameLikeAndAddressCityWhere() {
			Specification<Customer> spec1 = (root,cq,cb) ->
			cb.like(cb.lower(root.get(Customer_.name)), "a".concat("%"));
			
			Specification<Customer> spec2 = (root,cq,cb) ->	
			cb.equal(root.get(Customer_.address).get(Address_.city), "Yangon");
			
			var list = repo.findAll(spec1.and(spec2));
			System.out.println(list);
	}
}
