package com.jdc.mkt.model.entity.product;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Size;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

	private int id;
	@NotEmpty(message = "Please type product name !")
	private String name;
	@NotNull(message = "Please select one category !")
	private Category category;
	@NotNull(message = "Please select one size !")
	private Size size;
}
