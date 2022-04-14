package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver,Integer> {
	@Transactional
	@Modifying(flushAutomatically = true)
	@Query(value = "update Driver d set d.password=:pass where d.username=:uname", nativeQuery = true)
	public int updateDriverByUsername(@Param(value = "pass") String pass,@Param(value = "uname") String uname);
	

}
