package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_tbl")
@NamedQuery(name = "Customer.findWithName",
			query = "select c from Customer c where lower(name) like lower(:name)")
@NamedNativeQuery(
		name = "Customer.selectWithMemberType",
		query="select * from customer_tbl where member_type = ?1",
		resultClass = Customer.class
		)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(name = "member_type")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	@OneToOne(mappedBy = "customer")
	private Contact contact;
	
	public enum MemberType{
		NoMember,Silver,Gold,Platinum,Diamond
	}
}
