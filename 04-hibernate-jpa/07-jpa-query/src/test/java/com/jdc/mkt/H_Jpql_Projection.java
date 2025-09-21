package com.jdc.mkt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.dto.SelectPNameWithCName;
import com.jdc.mkt.entity.dto.SelectPNameWithSaleQty;
import com.jdc.mkt.utils.JpaFactory;

public class H_Jpql_Projection extends JpaFactory{

	@Test
	void selectSaleProductWithQty() {
		var query = em.createQuery("""
				select new com.jdc.mkt.entity.dto.SelectPNameWithSaleQty(
				vd.product.name,sum(vd.qty) as qtys) from VoucherDetail vd 
				group by vd.product.name 
				order by qtys desc
				""",SelectPNameWithSaleQty.class);
		var list = query.getResultList();
		list.forEach(p -> System.out.println(p.name()+"\t"+p.qtys()));
		
	}
	
	@Test
	@Disabled
	void selectWithProjection() {
		var query = em.createQuery("""
				select new com.jdc.mkt.entity.dto.SelectPNameWithCName(p.name,p.category.name) 
				from Product p
				""",SelectPNameWithCName.class);
		var list = query.getResultList();
		System.out.println(list);
	}
}
