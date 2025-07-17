package com.example.simple_crm;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// customerServiceImpl bean is a type of CustomerService
@Primary
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private InteractionRepository interactionRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, InteractionRepository interactionRepository) {
        this.customerRepository = customerRepository;
        this.interactionRepository = interactionRepository;
    }

    // CRUD
    // Create
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Read
    // Read One
    @Override
    public Customer getCustomer(Long id) {
        Customer foundCustomer = customerRepository.findById(id).get();

        // Retrieve the customer object and return
        return foundCustomer;
    }

    // Read All
    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("1️⃣ CustomerServiceImpl.getAllCustomers() called");
        List<Customer> allCustomers = customerRepository.findAll();
        return allCustomers;
    }

    // Update
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        // Retrieve the customer from the database
        Customer customerToUpdate = customerRepository.findById(id).get();
        // Update the fields of the customer retrieved
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setContactNo(customer.getContactNo());
        customerToUpdate.setJobTitle(customer.getJobTitle());
        customerToUpdate.setYearOfBirth(customer.getYearOfBirth());
        // Save the updated customer back to the database
        return customerRepository.save(customerToUpdate);
    }

    // Delete
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Interaction addInteractionToCustomer(Long id, Interaction interaction) {

        // Retrieve the customer from the database
        Customer selectedCustomer = customerRepository.findById(id).get();
        // Add the customer to the interaction
        interaction.setCustomer(selectedCustomer);
        return interactionRepository.save(interaction);
    }

}
