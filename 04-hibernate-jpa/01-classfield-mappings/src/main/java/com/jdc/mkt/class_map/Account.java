package com.jdc.mkt.class_map;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	
}
