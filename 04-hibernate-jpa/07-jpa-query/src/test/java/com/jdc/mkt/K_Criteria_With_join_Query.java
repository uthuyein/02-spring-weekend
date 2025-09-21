package com.jdc.mkt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.utils.JpaFactory;

public class K_Criteria_With_join_Query extends JpaFactory{
	
	@Test
	/*
	 * select * from category_tbl c 
	 * join product_tbl p on p.category_id = c.id
	 * where lower(p.name) like lower(?)
	 */
	void selectCategoryByProductNameTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Category.class);
		
		var root = cq.from(Category.class);
		cq.select(root);
		
		//Join with category_tbl
		var joinProduct = root.join(Category_.products);
		
		var predicate = cb.like(
						cb.lower(
							joinProduct.get(Product_.name)),
							"s".concat("%"));				
		
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(c -> System.out.println(c.getName()));
	}

	@Test
	@Disabled
	/*
	 * select * from product_tbl p 
	 * join category_tbl c on p.category_id = c.id
	 * where c.name = ?
	 */
	void selectProductByCategoryNameTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Product.class);
		
		var root = cq.from(Product.class);
		cq.select(root);
		
		//Join with category_tbl
		var jCat = root.join(Product_.category);
		
		var predicate = cb.equal(jCat.get(Category_.name), "Electronics");
		
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(p -> System.out.println(p.getName()));
	}
}
