package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.entity.product.SearchByPNameLikeAndDtPrice;
import com.jdc.mkt.entity.voucher.SearchByPNameCNameCuNameAndvDate;
import com.jdc.mkt.service.ProductService;
import com.jdc.mkt.service.VoucherService;

@SpringBootTest
public class C_ProductDynamicSearchTest {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private VoucherService vService;

	//select product by dtprice between 1000 and 2000
	//select product by name like 'a'
	//select product by dtprice equal wsprice
	
	@Test
	void searchVoucherBy() {
		var list = vService.search(new SearchByPNameCNameCuNameAndvDate(null,"Diary","mahar swe","2025-11-01",null));
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void searchProductBy() {
		var list = pService.searchBy(new SearchByPNameLikeAndDtPrice("Diary","m", 0, 0));
		System.out.println(list);
	}
	
	
}
