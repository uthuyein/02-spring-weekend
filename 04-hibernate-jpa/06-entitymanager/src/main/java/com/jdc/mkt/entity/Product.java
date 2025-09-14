package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.entity.listener.EnableTimeListener;
import com.jdc.mkt.entity.listener.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@Entity
@Table(name = "product_tbl")
@NoArgsConstructor
@RequiredArgsConstructor
//@EntityListeners(TimesListener.class)
public class Product implements EnableTimeListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false,length = 45)
	private String name;
	
	@NonNull
	@ColumnDefault("1.0")
	private Double price;
	
	@ColumnDefault("true")
	private boolean active;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Category category;
	
	@Embedded
	private Times times;
	
//	@PrePersist
//	void beforePersist() {		
//	System.out.println("Before persist");
//	
//	if(null == times) {
//		times = new Times();
//		this.setTimes(times);
//	}
//	times.setCreateTime(LocalDateTime.now());
//	}
//	
//	@PostPersist
//	void postPersist() {
//		System.out.println("After persist");
//	}
	
}
