package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	
	@Transactional
	@Modifying(flushAutomatically = true)
	@Query(value = "update Customer c set c.password=:pass where c.username=:uname", nativeQuery = true)
	public int updateCustomerByUsername(@Param(value = "pass") String pass,@Param(value = "uname") String uname);

	public Customer findByCustomerId(int customer_id);

	public Customer findByCustomerUsername(String username);



}
