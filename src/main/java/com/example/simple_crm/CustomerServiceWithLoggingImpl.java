package com.example.simple_crm;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceWithLoggingImpl implements CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerServiceWithLoggingImpl.class);

    // private CustomerRepository customerRepository = new CustomerRepository();
    private CustomerRepository customerRepository;


    public CustomerServiceWithLoggingImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CRUD
    // Create
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    // Read
    // Read one
    @Override
    public Customer getCustomer(String id) {
        // Find the index/position of the customer based on id
        int foundIndex = getCustomerIndex(id);
        // Retrieve the customer object and return
        return customerRepository.getCustomer(foundIndex);

    }

    // Read all
    @Override
    public ArrayList<Customer> getAllCustomers() {
        logger.info("2️⃣ CustomerServiceWithLoggingImpl.getAllCustomers() called");
        return customerRepository.getAllCustomers();
    }

    // Update
    @Override
    public Customer updateCustomer(String id, Customer customer) {
        int foundIndex = getCustomerIndex(id);
        return customerRepository.updateCustomer(foundIndex, customer);
    }

    // Delete
    @Override
    public void deleteCustomer(String id) {
        int foundIndex = getCustomerIndex(id);
        customerRepository.deleteCustomer(foundIndex);
    }

    // Helper method
    private int getCustomerIndex(String id) {
        for (Customer customer : customerRepository.getAllCustomers()) {
            if (customer.getId().equals(id)) {
                return customerRepository.getAllCustomers().indexOf(customer);
            }
        }

        // Customer id not found
        // return -1;
        throw new CustomerNotFoundException(id);
    }
}
