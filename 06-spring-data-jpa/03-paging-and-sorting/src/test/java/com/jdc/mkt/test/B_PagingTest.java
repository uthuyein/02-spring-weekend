package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.repo.ProductRepo;
import com.jdc.mkt.model.repo.VoucherRepo;

@SpringBootTest
public class B_PagingTest {

	@Autowired
	private VoucherRepo repo;
	
	@Autowired
	private ProductRepo pRepo;
	
	@Test
	void findProductByCatName() {
		var pagable = PageRequest.of(3, 8,Direction.DESC , "name");
		var page = pRepo.findAllProductByCatName("Diary", pagable);
		showPage(page);
	}
	
	@Disabled
	@Test
	void findProductWithActiveAndPag() {
		var sort = Sort.by("name");
		var pagable = PageRequest.of(5, 10,sort);
		var page = pRepo.findProductByActive(pagable,true);
		
		showPage(page);
	}
	
	private void showPage(Page<Product> page) {
		System.out.println("Total Size  :"+page.getSize());
		System.out.println("Total pages count :"+page.getTotalPages());
		System.out.println("Total elements count:"+page.getTotalElements());
		System.out.println("Current page number :"+page.getNumber());
		
		
		
	}
	
//	@Test
//	void voucherByProductName() {
//		
//		var list = repo.selectVoucherByVoucherDetailsProductName("Popcorn");
//		list.forEach(l -> System.out.println(l.getVoucherDetails()));
//	}
}
