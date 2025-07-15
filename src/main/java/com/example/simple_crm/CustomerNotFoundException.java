package com.example.simple_crm;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String id) {
        super("Could not find customer with id: " + id);
    }
}
