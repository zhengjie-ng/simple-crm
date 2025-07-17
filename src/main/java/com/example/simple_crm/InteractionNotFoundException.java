package com.example.simple_crm;

public class InteractionNotFoundException extends RuntimeException{
        public InteractionNotFoundException(String id) {
        super("Could not find interaction with id: " + id);
    }
    
}
