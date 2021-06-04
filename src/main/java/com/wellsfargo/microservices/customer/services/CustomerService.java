package  com.wellsfargo.microservices.customer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.microservices.customer.Customer;
import com.wellsfargo.microservices.customer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;


	public Customer insertCustomer(Customer e) {
		return customerRepository.save(e);

	}

	public Optional<Customer> getCustomer(Long id) {
		return Repository.findById(id);
	}

}
