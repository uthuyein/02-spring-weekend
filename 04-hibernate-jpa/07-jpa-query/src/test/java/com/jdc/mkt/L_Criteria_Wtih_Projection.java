package com.jdc.mkt;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.entity.dto.SelectPNameWithCName;
import com.jdc.mkt.utils.JpaFactory;

public class L_Criteria_Wtih_Projection extends JpaFactory{

	@Test
	//@Disabled
	/*
	 * select p.name,c.name from product_tbl p
	 * join category_tbl c on p.category_id = c.id
	 */	
	void multiSelectWithProjectionTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectPNameWithCName.class);
		
		var root = cq.from(Product.class);

		cq.multiselect(
				root.get(Product_.name)
					.alias("product"),
				root.get(Product_.category).
					get(Category_.name)
					.alias("category")
				);
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(c -> System.out.println(c.cName()));
		
	}
	
	@Test	
	/*
	 * select p.name,c.name from product_tbl p
	 * join category_tbl c on p.category_id = c.id
	 */	
	void selectWithProjectionTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectPNameWithCName.class);
		
		var root = cq.from(Product.class);
		cq.select(
				cb.construct(
						SelectPNameWithCName.class,
						root.get(Product_.id),
						root.get(Product_.name),
						root.get(Product_.category).
						get(Category_.name)
						));
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(c -> System.out.println(c.cName()));
		
	}
}
