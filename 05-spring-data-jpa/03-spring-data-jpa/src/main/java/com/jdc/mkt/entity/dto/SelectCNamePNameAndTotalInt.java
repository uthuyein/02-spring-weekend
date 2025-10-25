package com.jdc.mkt.entity.dto;

import org.springframework.beans.factory.annotation.Value;

public interface SelectCNamePNameAndTotalInt {

	String getCategory();
	String getProduct();
	Long getQtys();
	
	@Value("#{target.product+'   '+target.price}")
	String getProductDetail();
	
	public default void showResult() {
		System.out.println("Category :"+getCategory()+"Product :"+getProductDetail());
	}
}
