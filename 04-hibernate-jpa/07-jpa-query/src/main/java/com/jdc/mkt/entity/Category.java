package com.jdc.mkt.entity;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.entity.dto.SelectPNameWithCName;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category_tbl")
@NamedNativeQuery(
		name = "category.selectPNameAndCName",
		query = """
				select p.id,p.name product,c.name category from category_tbl c
				join product_tbl p on p.category_id = c.id
				""",
		resultSetMapping = "map.selectPNameAndCName")

@SqlResultSetMapping(
		name = "map.selectPNameAndCName",
		classes = {
		@ConstructorResult(
				targetClass = SelectPNameWithCName.class, 
				columns = {
						@ColumnResult(name = "p.id",type = Integer.class),
						@ColumnResult(name = "product",type = String.class),
						@ColumnResult(name = "category",type = String.class)
				}) })
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 25, unique = true)
	private String name;

	@ColumnDefault("true")
	private boolean active;

	@OneToMany(mappedBy = "category")
	private List<Product> products;

}
