package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CustomerController {
	@Autowired
	CustomerRepository crepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer customerData) {
		Customer customer=crepo.findByCustomerId(customerData.getCustomer_id());
		if(customer.getPassword().equals(customerData.getPassword()))
			return ResponseEntity.ok(customer);
		
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	
	
	@PostMapping("saveCustomer")
	public String saveCustomer(@RequestBody Customer customer) {
		crepo.save(customer);
//		System.out.println(customer.getCustomer_id()+","+customer.getUsername()+","+customer.getEmail()+","+customer.getPassword()+","+customer.getMobile_number());
		return "Sucessfully";
	}
	
	@PutMapping("updateCustomerPass")
	public String updateCustomer(@RequestBody Customer customer) {
		crepo.updateCustomerByUsername(customer.getPassword(),customer.getUsername());
		return customer.getUsername() + " your password is updated sucessfully";
	}
	
}
