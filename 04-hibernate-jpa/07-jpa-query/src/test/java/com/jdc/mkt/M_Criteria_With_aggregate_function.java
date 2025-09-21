package com.jdc.mkt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Customer_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.entity.VoucherDetail_;
import com.jdc.mkt.entity.Voucher_;
import com.jdc.mkt.entity.dto.SelectPNameWithSaleQty;
import com.jdc.mkt.utils.JpaFactory;

public class M_Criteria_With_aggregate_function extends JpaFactory{

	@ParameterizedTest
	@CsvSource({
		"Gold,"
	})
	/*
	 select p.name,sum(vd.qty) from product_tbl p
	  join voucher_detail_tbl vd on vd.product_id = p.id
	  join voucher_tbl v on vd.voucher_id = v.id
	  join customer_tbl c on v.customer_id = c.id
	  where c.member_type = 'Gold'
	  group by ,p.name;
	 */
	void selectMaxProductByCustomerTypeTest(String type,String res) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectPNameWithSaleQty.class);
		
		var root = cq.from(Product.class);
		var jVoucherDetail = root.join(Product_.voucherDetails);
		
		cq.multiselect(
				root.get(Product_.name),
				cb.sumAsLong(jVoucherDetail.get(VoucherDetail_.qty))
				);
		
		var predicate = jVoucherDetail
					.get(VoucherDetail_.voucher)
					.get(Voucher_.customer)
					.get(Customer_.memberType);
		
		cq.where(cb.equal(predicate, type));
		cq.groupBy(root.get(Product_.name));
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(o -> System.out.println(o.name()+"\t"+o.qtys()));
		
	}
	
	@Test
	@Disabled
	/*
	 * select p.name,sum(vd.qty) from product_tbl p
	 * join voucherDetail_tbl vd on vd.product_id = p.id
	 * group by p.name
	 */
	void selectPNameWithSaleQtyTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectPNameWithSaleQty.class);
		
		var root = cq.from(Product.class);
		var joinVoucherDetail = root.join(Product_.voucherDetails);
		
		cq.multiselect(
				root.get(Product_.name).alias("name"),
				cb.sumAsLong(joinVoucherDetail
						.get(VoucherDetail_.qty))
						.alias("qty")
				);
		cq.groupBy(root.get(Product_.name));
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.forEach(o -> System.out.println(o.name()+"\t"+o.qtys()));
		
		
	}
}
