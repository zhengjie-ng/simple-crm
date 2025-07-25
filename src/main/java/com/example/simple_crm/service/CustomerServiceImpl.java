package com.example.simple_crm.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.simple_crm.entity.Customer;
import com.example.simple_crm.entity.Interaction;
import com.example.simple_crm.exception.CustomerNotFoundException;
import com.example.simple_crm.repository.CustomerRepository;
import com.example.simple_crm.repository.InteractionRepository;

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
        // Optional<Customer> optionalCustomer = customerRepository.findById(id);

        // if (optionalCustomer.isPresent()) {
        // Customer foundCustomer = optionalCustomer.get();
        // // Retrieve the customer object and return
        // return foundCustomer;
        // }

        // throw new CustomerNotFoundException(id);

        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
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
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        // Update the fields of the customer retrieved
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setContactNo(customer.getContactNo());
        customerToUpdate.setJobTitle(customer.getJobTitle());
        customerToUpdate.setYearOfBirth(customer.getYearOfBirth());
        // Save the updated customer back to the database
        return customerRepository.save(customerToUpdate);

        // Optional<Customer> optionalCustomer = customerRepository.findById(id);
        // if (optionalCustomer.isPresent()) {
        // Customer foundCustomer = optionalCustomer.get();
        // foundCustomer.setFirstName(customer.getFirstName());
        // foundCustomer.setLastName(customer.getLastName());
        // foundCustomer.setEmail(customer.getEmail());
        // foundCustomer.setContactNo(customer.getContactNo());
        // foundCustomer.setJobTitle(customer.getJobTitle());
        // foundCustomer.setYearOfBirth(customer.getYearOfBirth());
        // // Retrieve the customer object and return
        // return customerRepository.save(foundCustomer);
        // }
        // throw new CustomerNotFoundException(id);

        // // Retrieve the customer from the database
        // Customer customerToUpdate = customerRepository.findById(id).get();
        // // Update the fields of the customer retrieved
        // customerToUpdate.setFirstName(customer.getFirstName());
        // customerToUpdate.setLastName(customer.getLastName());
        // customerToUpdate.setEmail(customer.getEmail());
        // customerToUpdate.setContactNo(customer.getContactNo());
        // customerToUpdate.setJobTitle(customer.getJobTitle());
        // customerToUpdate.setYearOfBirth(customer.getYearOfBirth());
        // // Save the updated customer back to the database
        // return customerRepository.save(customerToUpdate);
    }

    // Delete
    @Override
    public void deleteCustomer(Long id) {
        // Optional<Customer> optionalCustomer = customerRepository.findById(id);
        // if (optionalCustomer.isPresent()) {
        //     customerRepository.deleteById(id);
        // }
        // throw new CustomerNotFoundException(id);

        customerRepository.deleteById(id);
    }

    @Override
    public Interaction addInteractionToCustomer(Long id, Interaction interaction) {
        // Retrieve the customer from the database
        Customer selectedCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        // Add the customer to the interaction
        interaction.setCustomer(selectedCustomer);
        return interactionRepository.save(interaction);
        // Optional<Customer> optionalCustomer = customerRepository.findById(id);
        // if (optionalCustomer.isPresent()) {
        // Customer foundCustomer = optionalCustomer.get();
        // interaction.setCustomer(foundCustomer);
        // return interactionRepository.save(interaction);

        // }
        // throw new CustomerNotFoundException(id);

        // // Retrieve the customer from the database
        // Customer selectedCustomer = customerRepository.findById(id).get();
        // // Add the customer to the interaction
        // interaction.setCustomer(selectedCustomer);
        // return interactionRepository.save(interaction);
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
        List<Customer> foundCustomers = customerRepository.findByFirstName(firstName);
        return foundCustomers;
    }

    @Override
    public List<Customer> findByFirstNameContainingIgnoreCase(String firstName) {
        List<Customer> foundCustomers = customerRepository.findByFirstNameContainingIgnoreCase(firstName);
        return foundCustomers;
    }

    @Override
    public List<Customer> findByInteractionsIsEmpty() {
        return customerRepository.findByInteractionsIsEmpty();
    }

}
