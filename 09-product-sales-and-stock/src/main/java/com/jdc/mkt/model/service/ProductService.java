package com.jdc.mkt.model.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Category;
import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.entity.Size;
import com.jdc.mkt.model.entity.product.CategoryForm;
import com.jdc.mkt.model.entity.product.ProductForm;
import com.jdc.mkt.model.entity.product.SelectProduct;
import com.jdc.mkt.model.entity.product.SizeForm;
import com.jdc.mkt.model.repo.CategoryRepo;
import com.jdc.mkt.model.repo.ProductRepo;
import com.jdc.mkt.model.repo.SizeRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class ProductService {

	@Autowired
	private CategoryRepo catRepo;
	@Autowired
	private SizeRepo sizeRepo;
	@Autowired
	private ProductRepo prodRepo;
	
	public List<SelectProduct> products(){
		return prodRepo.findAll().stream().map(SelectProduct :: selectProduct).toList();
	}
	
	public ProductForm productForm(Integer id) {
		return null == id ? new ProductForm():prodRepo.findById(id).map(ProductForm::from).orElse(new ProductForm());
	}

	public Category saveCategory(CategoryForm form) {
		if(null == catRepo.findByName(form.getName())) {	
			return catRepo.save(form.entity());
		}
		return null;
	}

	public Size saveSize(SizeForm form) {	
		if(null == sizeRepo.findByName(form.getName())) {
			sizeRepo.save(form.entity());
		}
		return null;
	}
	
	public SelectProduct saveProduct(ProductForm form) {
		
		var list = prodRepo.searchBy(searchFunction(form));
		if(null == list || list.isEmpty()) {
			return SelectProduct.selectProduct(prodRepo.save(form.entity()));
		}		
		return null;
	}
	
	
	private Function<CriteriaBuilder,CriteriaQuery<SelectProduct>> searchFunction(ProductForm search) {
		return  cb -> {
			
			var query = cb.createQuery(SelectProduct.class);	
			var root = query.from(Product.class);		
			SelectProduct.select(query,root);	
			query.where(search.search(cb,root));
			
			return query;
		};
		
		
	}
}
