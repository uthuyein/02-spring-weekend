package com.jdc.mkt.class_map;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "person_class_tbl",
	indexes = {
			@Index(columnList = "name")
	})
@SecondaryTables({
	@SecondaryTable(name = "contact_tbl",
			uniqueConstraints = {
			@UniqueConstraint(columnNames = {"email","phone"})
	}),
	@SecondaryTable(name = "address_tbl")
})
public class PersonClass {

	@Id
	private Integer id;	
	private String name;
	@Embedded
	private Account account;
	
	@Column(table = "contact_tbl")
	private String email;
	@Column(table = "contact_tbl")
	private String phone;
	@Column(table = "address_tbl")
	private String state;
	@Column(table = "address_tbl")
	private String township;
	@Column(table = "address_tbl")
	private String street;
}
