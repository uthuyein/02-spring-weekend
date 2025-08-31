package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UserPk implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "profile_id")
	private int profileId;
	private LocalDate createDate;
	private LocalTime createTime;
}
