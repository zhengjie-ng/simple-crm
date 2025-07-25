package com.example.simple_crm.service;

import java.util.List;

import com.example.simple_crm.entity.Customer;
import com.example.simple_crm.entity.Interaction;

public interface CustomerService {
  Customer createCustomer(Customer customer);

  Customer getCustomer(Long id);

  List<Customer> getAllCustomers();

  Customer updateCustomer(Long id, Customer customer);

  void deleteCustomer(Long id);

  Interaction addInteractionToCustomer(Long id, Interaction interaction);

  List<Customer> findByFirstName(String firstName);

  List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

  List<Customer> findByInteractionsIsEmpty();

}

