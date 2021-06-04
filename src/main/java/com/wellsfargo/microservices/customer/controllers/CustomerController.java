package com.wellsfargo.microservices.customer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wellsfargo.microservices.customer.Customer;
import com.wellsfargo.microservices.customer.CustomerRepository;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> retrieveAllCustomers() {
		return ResponseEntity.ok(customerRepository.findAll());
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> retrieveCustomer(@PathVariable long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return ResponseEntity.ok(customer.get());
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable long id) {
		customerRepository.deleteById(id);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(savedCustomer);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer  customer, @PathVariable long id) {

		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent())
			return ResponseEntity.notFound().build();

		customer.setCustomerId(id);
		Customer saveCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(savedCustomer);
	}
}
