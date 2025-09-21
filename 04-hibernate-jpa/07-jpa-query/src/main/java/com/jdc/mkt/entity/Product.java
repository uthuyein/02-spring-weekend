package com.jdc.mkt.entity;

import java.util.List;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_tbl")
@Check(constraints = "dt_price >= ws_price")
@NamedQuery(name = "countByProductDtPrice",
			query = "select count(p) from Product p where p.dtPrice between :from and :to")
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
	private Category category ;
	
	@OneToMany(mappedBy = "product")
	private List<VoucherDetail> voucherDetails;
	
}
