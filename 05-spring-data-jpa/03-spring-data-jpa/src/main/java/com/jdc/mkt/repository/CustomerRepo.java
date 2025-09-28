package com.jdc.mkt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer.MemberType;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	//By Using NamingRules
	List<Customer> findCustomerByContactEmail(String name);
	
	//By Using Jpql
	@Query("select c from Customer c where c.contact.email = :name")
	List<Customer> findByEmail(@Param("name") String name);
	
	//By Using Native Sql
	@Query(nativeQuery = true,
		  value = """
		  		select cu.name from customer_tbl cu join 
		  		contact_tbl c on c.customer_id = cu.id
		  		where c.primaryPhone = :phone or c.secondaryPhone = :phone
		  		""")
	List<String> findByContact(@Param("phone") String phone);
	
	//Static
	//1.JPQL
	//By Using NamedQuery in target entity
	//Using with param name
	List<Customer> findWithName(@Param("name")String name);
	
	//2.Native
	//@query in name attribute is using by different @namequery name
	//Using with param index
	@Query(name = "Customer.selectWithMemberType",nativeQuery = true)
	List<Customer> findWithMember(MemberType type);
	
}






