package com.jdc.mkt.field_map;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class MapEmb implements Serializable{
	private static final long serialVersionUID = 1L;

	private int data1;
	private String data2;
//	@ElementCollection
//	private List<String> names;
}
