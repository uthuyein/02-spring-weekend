package com.jdc.mkt.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "messenger_tbl")
public class Messenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "message_type")
	@Enumerated(EnumType.STRING)
	private MessageType messageType;
	
	@Column(nullable = false)
	private String message;
	
	public enum MessageType{
		Information,Confirmation,Warning
	}
}

