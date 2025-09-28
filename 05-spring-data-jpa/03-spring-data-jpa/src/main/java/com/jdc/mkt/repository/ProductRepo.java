package com.jdc.mkt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalQty;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByCategoryName(String name);
	
	List<Product> getProductByNameLike(String name);
	
	List<Product> findFirst3ByNameStartsWith(String name);

	Long countProductBydtPriceLessThanEqual(double d);
	
	//select p.name,sum(vd.qty)
	@Query("""
				select new com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalQty(
				p.category.name category,p.name product,sum(vd.qty) qtys)  
				from Product p join p.voucherDetails vd
				group by p.category.name,p.name
			""")
	List<SelectCNamePNameAndTotalQty> selectWithCNamePNameAndQty();
}
