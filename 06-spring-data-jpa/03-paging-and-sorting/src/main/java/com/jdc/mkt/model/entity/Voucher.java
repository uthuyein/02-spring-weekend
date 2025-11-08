package com.jdc.mkt.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "voucher_tbl")
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "date default(current_date)")
	private LocalDate saleDate;
	@Column(columnDefinition = "time default(current_time)")
	private LocalTime saleTime;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "voucher")
	private List<VoucherDetail> voucherDetails;
	
}
