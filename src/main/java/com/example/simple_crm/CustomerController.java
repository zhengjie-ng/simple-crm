package com.example.simple_crm;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerController() {
        customers.add(Customer.builder().firstName("Bruce").lastName("Banner").build());
        customers.add(Customer.builder().firstName("Peter").lastName("Parker").build());
        customers.add(Customer.builder().firstName("Stephen").lastName("Strange").build());
        customers.add(Customer.builder().firstName("Steve").lastName("Roger").build());
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        // Get the customer and add it to the ArrayList
        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // READ
    // Read all
    @GetMapping
    // public ArrayList<Customer> getAllCustomers() {
    public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
        // return customers;
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        try {
            int index = getCustomerIndex(id);
            return new ResponseEntity<>(customers.get(index), HttpStatus.OK);
            // return customers.get(index);
        } catch (CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        try {
            int index = getCustomerIndex(id);
            customers.set(index, customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
            // return customer;
        } catch (CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String id) {
        try {
            int index = getCustomerIndex(id);
            customers.remove(index);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // return customers.remove(index);
        } catch (CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Helper method
    private int getCustomerIndex(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customers.indexOf(customer);
            }
        }

        // Customer id not found
        // return -1;
        throw new CustomerNotFoundException(id);
    }

}
