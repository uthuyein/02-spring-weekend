package com.jdc.mkt;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectPNameWithCName;
import com.jdc.mkt.utils.JpaFactory;

@SuppressWarnings("unchecked")
public class I_Native_query extends JpaFactory{
	
	@Test
	@Order(2)
	void staticQueryWithResultMappingTest() {
		var  query = em.createNamedQuery("category.selectPNameAndCName", SelectPNameWithCName.class);
		var list = query.getResultList();
		System.out.println(list);
	}

	@Test
	@Order(1)
	//@Disabled
	//For Projection
	//1.Used alias name when column is duplicated 
	//  and call that name from column result
	//2.must be same selected column name and column result name
	void dynamicQueryWithResultMappingTest() {
		var query = em.createNativeQuery("""
				select p.id,p.name product,c.name category from category_tbl c
				join product_tbl p on p.category_id = c.id
				""","map.selectPNameAndCName");
		List<SelectPNameWithCName> list = query.getResultList();
		list.forEach(c -> System.out.println(c.pName()));
	}
	@Test
	@Disabled	
	void dynamicQueryWithResultClassTest() {
		var query = em.createNativeQuery("""
				select * from product_tbl
				""",Product.class);
		
		//Return type need to declare ,can't used with var
		List<Product> list = query.getResultList();
		list.forEach(p -> System.out.println(p.getName()));
		
	}
}
