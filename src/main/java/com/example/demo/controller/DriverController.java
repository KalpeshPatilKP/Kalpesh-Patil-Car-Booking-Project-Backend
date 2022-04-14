package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverRepository;
import com.example.demo.service.DriverService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class DriverController {
	
	
	@Autowired
	DriverRepository drepo;
	@PostMapping("saveDriver")
	public String saveDriver(@RequestBody Driver driver) {
		drepo.save(driver);
//		System.out.println(driver.getDriver_id()+","+driver.getUsername()+","+driver.getEmail()+","+driver.getPassword()+","+driver.getMobile_number());
		return "Sucessfully";
		
	}
	
	@PutMapping("updateDriverPass")
	public String updateDriver(@RequestBody Driver driver) {
		drepo.updateDriverByUsername(driver.getPassword(), driver.getUsername());
		return driver.getUsername() + " your password is updated sucessfully";
	}
	
//	@GetMapping("getAllDrivers")
//	public String getAllDrivers() {
//		drepo.find
//		
//	}
	
	
//	@GetMapping("msg")
//	public String getMsg() {
//		return "Hello World";
//	}

}
