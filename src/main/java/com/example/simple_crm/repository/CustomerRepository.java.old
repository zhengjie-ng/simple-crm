package com.example.simple_crm;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.add(Customer.builder().firstName("Bruce").lastName("Banner").build());
        customers.add(Customer.builder().firstName("Peter").lastName("Parker").build());
        customers.add(Customer.builder().firstName("Stephen").lastName("Strange").build());
        customers.add(Customer.builder().firstName("Steve").lastName("Roger").build());
    }

    // CRUD methods
    // Create
    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    // Read
    // Read one
    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    // Read all
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    // Update
    public Customer updateCustomer(int index, Customer customer) {
        Customer customerToUpdate = customers.get(index);
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setContactNo(customer.getContactNo());
        customerToUpdate.setJobTitle(customer.getJobTitle());
        customerToUpdate.setYearOfBirth(customer.getYearOfBirth());

        return customerToUpdate;
    }

    // Delete
    public void deleteCustomer(int index) {
        customers.remove(index);
    }
}
