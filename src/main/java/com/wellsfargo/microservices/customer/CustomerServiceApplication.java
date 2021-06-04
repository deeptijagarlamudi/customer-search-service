package com.wellsfargo.microservices.customer

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration+@EnableAutoConfiguration+@ComponentScan
public class CustomerServiceApplication {
	public static void main(String args[]) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}