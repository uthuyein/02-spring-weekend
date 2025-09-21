package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Customer.MemberType;
import com.jdc.mkt.utils.JpaFactory;

public class G_jpql_query extends JpaFactory {
	
	@ParameterizedTest
	@CsvSource({
		"Silver,3"
	})
	void selectProductByMemberType(String memberType,int size) {
		var query = em.createQuery("""
				select p from Product p 
				join p.voucherDetails vd
				where vd.voucher.customer.memberType = :type
				""",Product.class);
		query.setParameter("type", MemberType.valueOf(memberType));
		var list = query.getResultList();
		assertEquals(size, list.size());
	}

	/*
	 * select * from product_tbl p
	 * join voucher_detail_tbl vd on vd.product_id = p.id
	 * join voucher_tbl v on vd.voucher_id = v.id
	 * join customer_tbl c on v.customer_id = c.id
	 * where c.name = ?
	 */
	
	@ParameterizedTest
	@CsvSource({
		"Alice Johnson,5"
	})
	void selectProductByCustomerBuy(String customer,int size) {
		var query = em.createQuery("""
				select vd.product from VoucherDetail vd 
				where vd.voucher.customer.name = :name
				""",Product.class);
		query.setParameter("name", customer);
		var list = query.getResultList();
		assertEquals(size, list.size());
	}
}
