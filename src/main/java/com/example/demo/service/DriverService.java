package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
	DriverRepository drepo;
	
	public Driver saveDriver(Driver d) {
		return drepo.save(d);
		
	}
	

}
