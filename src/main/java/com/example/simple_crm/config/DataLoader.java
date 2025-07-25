package com.example.simple_crm.config;

import org.springframework.stereotype.Component;

import com.example.simple_crm.entity.Customer;
import com.example.simple_crm.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
    private CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void loadData() {
        // Clear the database here
        customerRepository.deleteAll();

        // Load data
        customerRepository.save(Customer.builder().firstName("Bruce").lastName("Banner").yearOfBirth(1985).contactNo("12345678").build());
        customerRepository.save(Customer.builder().firstName("Peter").lastName("Parker").yearOfBirth(1975).contactNo("12345678").build());
        customerRepository.save(Customer.builder().firstName("Stephen").lastName("Strange").yearOfBirth(1978).contactNo("12345678").build());
        customerRepository.save(Customer.builder().firstName("Steve").lastName("Roger").yearOfBirth(1940).contactNo("12345678").build());
    }
}
