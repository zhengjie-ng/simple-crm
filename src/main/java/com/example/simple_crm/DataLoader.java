package com.example.simple_crm;

import org.springframework.stereotype.Component;

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
        customerRepository.save(Customer.builder().firstName("Bruce").lastName("Banner").build());
        customerRepository.save(Customer.builder().firstName("Peter").lastName("Parker").build());
        customerRepository.save(Customer.builder().firstName("Stephen").lastName("Strange").build());
        customerRepository.save(Customer.builder().firstName("Steve").lastName("Roger").build());
    }
}
