package com.jdc.mkt.entity;

import java.util.List;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalQty;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_tbl")
@Check(constraints = "dt_price >= ws_price")

//@NamedQuery(
//		name = "Product.selectWithCNamePNameAndQty",
//		
//		query = """
//				select new com.jdc.mkt.entity.dto.SelectCNamePNameAndTotalQty(
//				p.category.name,p.name,sum(vd.qty))  
//				from Product p join p.voucherDetails vd
//				group by p.category.name,p.name
//				""")
@SqlResultSetMapping(
		name = "selectWithCNamePNameAndQtyMapping", 
		classes = @ConstructorResult(
			targetClass = SelectCNamePNameAndTotalQty.class, 
			columns = {
						@ColumnResult(name = "category", type = String.class), 
						@ColumnResult(name = "product", type = String.class),
						@ColumnResult(name = "qtys", type = Long.class)
						}))

@NamedNativeQuery(name = "selectWithCNamePNameAndQtyBySql",
				resultSetMapping = "selectWithCNamePNameAndQtyMapping", query = """
		select c.name category,p.name product,sum(vd.qty) qtys
		from product_tbl p
		join category_tbl c on p.category_id = c.id
		join voucher_detail_tbl vd on vd.product_id = p.id
		group by c.name,p.name
		""")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(name = "dt_price")
	private double dtPrice;

	@Column(name = "ws_price")
	private double wsPrice;

	@ColumnDefault("true")
	private boolean active;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<VoucherDetail> voucherDetails;

}
