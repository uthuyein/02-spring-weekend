package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class User {

	@EmbeddedId
	private UserPk id;
	
	@Column(nullable = false,length = 45)
	private String name;
	private String username;
	private String password;
	
	@OneToOne
	@MapsId("profileId")
	//@PrimaryKeyJoinColumn
	//@JoinColumn(insertable = false,updatable = false)
	private UserProfile profile;
}
