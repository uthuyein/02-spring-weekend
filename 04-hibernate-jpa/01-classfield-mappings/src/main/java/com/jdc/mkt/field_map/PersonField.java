package com.jdc.mkt.field_map;

import java.time.LocalDate;
import java.util.Date;

import com.jdc.mkt.utils.Size;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="person_field_tbl")
public class PersonField {

	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@GeneratedValue(generator = "gen_person_field")
	@TableGenerator(name = "gen_person_field",initialValue = 1,allocationSize = 1)
	private int id;
	
	@Column(name = "field_name",length = 45 ,unique = true,nullable = false)
	private String name;
	
	@Basic
	private int age;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private LocalDate ldt;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	@Transient
	private String classDescribe;
	
	@Lob
	private String image;
	
	
}
