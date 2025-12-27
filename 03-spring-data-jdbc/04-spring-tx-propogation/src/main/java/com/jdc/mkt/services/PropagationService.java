package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.repo.CategoryRepo;
import com.jdc.mkt.repo.ProductRepo;

@Service
public class PropagationService {
	
	@Autowired
	private CategoryRepo catRepo;
	@Autowired
	private ProductRepo prodRepo;
	
	public record ServiceDetail(
			int catId,
			List<Integer> prodIds
			) {}
	
	@Transactional
	public ServiceDetail save(int state,String category,String ...products){
		 var catId = catRepo.create(category);
		 
		 if(state == 1) {
			 throw new RuntimeException();
		 }
		 
		 var productIds = prodRepo.create(catId, products);
		 
		 if(state == 2) {
			 throw new RuntimeException();
		 }
		 return new ServiceDetail(catId, productIds);
	}
}
