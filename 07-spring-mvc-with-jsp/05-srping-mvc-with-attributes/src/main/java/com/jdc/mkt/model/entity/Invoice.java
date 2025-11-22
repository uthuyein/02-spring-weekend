package com.jdc.mkt.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private int totalCount;
	private Double totalAmount;
	private LocalDateTime issuedDt;
	

}
