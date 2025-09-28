package com.jdc.mkt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@SuppressWarnings("unused")
public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void create(Category c) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Category.class);
		
		var root = cq.from(Category.class);
		cq.select(root);
		
		//Criteria query
		var q1 = em.createQuery(cq);
		var list1 = q1.getResultList();
		
		//Using jpql
		var q2 =em.createQuery("select c from Category ", Category.class);
		var list2 = q2.getResultList();
		
		//Using native sql
		var q3 =em.createNativeQuery("select * from category_tbl");
		var list3 = q3.getResultList();
		
		
		//manage entity
		em.find(Category.class,1);
	}
}
