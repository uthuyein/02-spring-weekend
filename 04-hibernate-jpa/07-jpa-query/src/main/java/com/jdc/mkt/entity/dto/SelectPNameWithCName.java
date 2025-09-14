package com.jdc.mkt.entity.dto;

public record SelectPNameWithCName(
		int id,
		String pName,
		 String cName
		) {	
	public SelectPNameWithCName(String pName,String cName) {
		this(0,pName,cName);
	}
	
}
