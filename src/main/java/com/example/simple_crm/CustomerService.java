package com.example.simple_crm;

import java.util.List;

public interface CustomerService {
  Customer createCustomer(Customer customer);

  Customer getCustomer(Long id);

  List<Customer> getAllCustomers();

  Customer updateCustomer(Long id, Customer customer);

  void deleteCustomer(Long id);

  Interaction addInteractionToCustomer(Long id, Interaction interaction);

}

