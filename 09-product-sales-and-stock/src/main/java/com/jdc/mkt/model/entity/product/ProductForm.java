package com.jdc.mkt.model.entity.product;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Size;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

	private Integer id;
	@NotEmpty(message = "Please type product name !")
	private String name;
	@NotNull(message = "Please select one category !")
	private Category category;
	@NotNull(message = "Please select one size !")
	private Size size;
	
	
	public Predicate[] search(CriteriaBuilder cb, Root<Product> root) {
		
		var params = new ArrayList<Predicate>();
		if (StringUtils.hasLength(name)) {
			params.add(cb.equal(root.get("name"), name));
		}
		if (null != category && null != category.getName()) {
			params.add(cb.equal(root.get("category").get("name"), category.getName()));
		}
		if (null != size && null != size.getName()) {
			params.add(cb.equal(root.get("size").get("name"), size.getName()));
		}
		return params.toArray(s -> new Predicate[s]);
	}
	
	public Product entity() {
		var p = new Product();
		p.setCategory(category);
		p.setSize(size);
		p.setName(name);
		return p;
	}
}
