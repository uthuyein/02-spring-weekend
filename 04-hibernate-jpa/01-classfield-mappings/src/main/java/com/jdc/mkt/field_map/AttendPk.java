package com.jdc.mkt.field_map;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AttendPk implements Serializable{

	private static final long serialVersionUID = 1L;
	private LocalDate inDate;
	private LocalTime inTime;
	private int personId;
	private transient String test;
}
