package com.example.simple_crm;

import java.util.List;

// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerService customerService;
  // private CustomerServiceWithLoggingImpl customerServiceWithLoggingImpl;
  // private CustomerService customerService = new CustomerService();

  // Spring Boot will find a bean of type CustomerService and inject here
  // which is customerServiceImpl
  // public CustomerController(@Qualifier("customerServiceImpl") CustomerService
  // customerService) {
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  // CREATE
  @PostMapping
  public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
    Customer newCustomer = customerService.createCustomer(customer);
    return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
  }

  // READ
  // Read all
  @GetMapping
  public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String firstName) {

    if (firstName != null && !firstName.trim().isEmpty()) {
      List<Customer> customers = customerService.findByFirstNameContainingIgnoreCase(firstName);
      return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    List<Customer> allCustomers = customerService.getAllCustomers();
    return new ResponseEntity<>(allCustomers, HttpStatus.OK);
  }

  // Read one
  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);

    // try {
    // Customer foundCustomer = customerService.getCustomer(id);
    // return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    // } catch (CustomerNotFoundException e) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
  }

  // UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
    Customer updatedCustomer = customerService.updateCustomer(id, customer);
    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    // try {
    // Customer updatedCustomer = customerService.updateCustomer(id, customer);
    // return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    // } catch (CustomerNotFoundException e) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    // try {
    // customerService.deleteCustomer(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (CustomerNotFoundException e) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
  }

  // NESTED ROUTE - add interaction to customer
  @PostMapping("/{id}/interactions")
  public ResponseEntity<Interaction> addInteractionToCustomer(@PathVariable Long id,
      @RequestBody Interaction interaction) {
    Interaction newInteraction = customerService.addInteractionToCustomer(id, interaction);
    return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);
  }

  // /search

  // /customers?type=no-interactions
  @GetMapping("/no-interactions")
  public ResponseEntity<List<Customer>> getCustomersWithNoInteractions() {
    return new ResponseEntity<>(customerService.findByInteractionsIsEmpty(), HttpStatus.OK);
  }

}