package com.jdc.mkt.field_map;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.EmbeddedId;
import lombok.Data;

//@Entity
@Data
//@IdClass(AttendPk.class)
public class Attend {

//	@Id
//	private LocalDate inDate;
//	@Id
//	private LocalTime inTime;
//	@Id
//	private int personId;
	
	@EmbeddedId
	private AttendPk id;
	private LocalDate outDate;
	private LocalTime outTime;
	private double workHrs;
	
}
