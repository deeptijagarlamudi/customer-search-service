package  com.wellsfargo.microservices.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.microservices.customer.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

}