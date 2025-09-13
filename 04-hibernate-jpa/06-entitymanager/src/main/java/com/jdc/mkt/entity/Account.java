package com.jdc.mkt.entity;

import com.jdc.mkt.entity.listener.EnableTimeListener;
import com.jdc.mkt.entity.listener.Times;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_tbl")
public class Account implements EnableTimeListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double balance;
	private Times times;
}
