package com.example.simple_crm.entity;

import java.util.UUID;

/*
 * 1. Create Product POJO
 * 2. Create ProductController - products ArrayList
 * 3. Create ProductNotFoundException
 * 4. In ProductController, add CRUD endpoints
 * 5. Return using ResponseEntity
 * 6. Handle ProductNotFoundException
 */

public class Product {
    // Instance Field
    private final String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private double price;
    
    // Constructors
    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    

    // Getters and Setters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}
