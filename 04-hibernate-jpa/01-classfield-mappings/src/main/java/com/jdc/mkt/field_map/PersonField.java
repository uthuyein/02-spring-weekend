package com.jdc.mkt.field_map;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name ="person_field_tbl")
public class PersonField {

	@Id
	private int id;
	private String name;
	private int age;
}
