package com.jdc.mkt.model.entity.product;

import com.jdc.mkt.model.entity.Size;

import lombok.Data;

@Data
public class SizeForm {

	private int id;
	private String name;
	private boolean active;
	
	public Size entity() {
		var s = new Size();
		s.setName(name);
		s.setActive(true);
		return s;
	}
}
