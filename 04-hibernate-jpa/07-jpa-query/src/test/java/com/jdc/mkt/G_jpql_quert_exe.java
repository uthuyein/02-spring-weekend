package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.dto.Product;

public class G_jpql_quert_exe extends JpaFactory {

	@ParameterizedTest
	@CsvSource({
		"Alice Johnson,5"
	})
	/*
	 * select * from product_tbl p
	 * join voucher_detail_tbl vd on vd.product_id = p.id
	 * join voucher_tbl v on vd.voucher_id = v.id
	 * join customer_tbl c on v.customer_id = c.id
	 * where c.name = ?
	 */
	
	void selectProductByCustomerBuy(String customer,int size) {
		var query = em.createQuery("""
				select vd.id.product from VoucherDetail vd 
				where vd.id.voucher.customer.name = :name
				""",Product.class);
		query.setParameter("name", customer);
		var list = query.getResultList();
		assertEquals(size, list.size());
	}
}
