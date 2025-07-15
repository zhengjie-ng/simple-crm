package com.example.simple_crm;

import java.util.ArrayList;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomer(String id);
    ArrayList<Customer> getAllCustomers();
    Customer updateCustomer(String id, Customer customer);
    void deleteCustomer(String id);

}
