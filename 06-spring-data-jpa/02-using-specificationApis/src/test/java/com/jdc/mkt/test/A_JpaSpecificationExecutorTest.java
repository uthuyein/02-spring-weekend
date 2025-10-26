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
public class A_JpaSpecificationExecutorTest {

	@Autowired
	private CustomerRepo repo;
	
	@Test
	void deleteByCustomerName() {
		Specification<Customer> spec = (root,query,cb) -> 
			cb.equal(root.get(Customer_.address).get(Address_.township), "Maharaungmyay");
			
		var row = repo.delete(spec);
		System.out.println("Delete record :"+row);
	}
	
	@Test
	@Disabled
	void findOneByCustomerPhone() {
		Specification<Customer> spec = (root,query,cb) -> 
			cb.equal(root.get(Customer_.phone), "02-522494");
		
			var entity = repo.findOne(spec).orElse(null);
			System.out.println(entity.getName());
	}
	
	@Test
	@Disabled
	void findAllByCustomerName() {
		Specification<Customer> spec = (root,query,cb) -> 
			cb.equal(root.get(Customer_.name),"andrew");
			
		var list = repo.findAll(spec);
		System.out.println(list);
	}
}

