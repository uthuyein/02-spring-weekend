package com.jdc.mkt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalInt;
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
	List<SelectCNamePNameAndTotalQty> selectWithCNamePNameAndQtyByJpql();
	
	@Query(nativeQuery = true,name = "selectWithCNamePNameAndQtyBySql")
	List<SelectCNamePNameAndTotalQty> selectWithCNamePNameAndQtyBySql();
	
	@Query(nativeQuery = true,value = """
			select c.name category,p.name product,p.dt_price price,sum(vd.qty) qtys
			from product_tbl p
			join category_tbl c on p.category_id = c.id
			join voucher_detail_tbl vd on vd.product_id = p.id
			group by c.name,p.name
			""")
	List<SelectCNamePNameAndTotalInt> selectWithCNamePNameAndQtyByInt();
	
	
}
