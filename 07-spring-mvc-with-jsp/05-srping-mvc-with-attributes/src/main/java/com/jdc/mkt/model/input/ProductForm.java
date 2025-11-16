package com.jdc.mkt.model.input;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Product.Size;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

	private Integer id;
	@NotBlank(message = "Please type product name !")
	private String name;
	@NotNull(message = "Please type product detail price !")
	private Double dtPrice;
	@NotNull(message = "Please type product whole sale price !")
	private Double wsPrice;
	@NotNull(message = "Please select product size !")
	private Size size;	
	@NotBlank(message = "Please type category name !")
	private String category;
	
	private Boolean active;

	public Product entity(Category cat) {
		var p = new Product();
		p.setCategory(cat);
		p.setName(name);
		p.setDtPrice(dtPrice);
		p.setWsPrice(wsPrice);
		p.setSize(size);
		p.setActive(true);
		return p;
	}
}
