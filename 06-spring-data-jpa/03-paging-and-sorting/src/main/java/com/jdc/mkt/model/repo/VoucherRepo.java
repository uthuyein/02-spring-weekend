package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Voucher;

public interface VoucherRepo extends JpaRepository<Voucher, Integer>{

//	@Query(value = """
//			select v from Voucher v join v.voucherDetails vd
//			where vd.product.name = ?1
//			""")
//	List<Voucher> selectVoucherByVoucherDetailsProductName(String name);

	
}
