package com.example.simple_crm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.simple_crm.entity.Customer;
import com.example.simple_crm.exception.CustomerNotFoundException;
import com.example.simple_crm.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    // We need to mock CustomerRepository
    // Because we don't want to test the repository layer
    @Mock
    private CustomerRepository customerRepository;

    // Inject the mocks as dependencies into CustomerServiceImpl
    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    public void createCustomerTest() {
        // ARRANGE
        // Create a new customer
        Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
                .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

        // Mock the save method of the customerRepository
        when((customerRepository.save(customer))).thenReturn(customer);

        // ACT
        Customer savedCustomer = customerService.createCustomer(customer);

        // ASSERT
        assertEquals(customer, savedCustomer, "The saved customer should be the same as the new customer");

        // Also verify that the save method of the customer repository is called once
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void getCustomerTest() {
        // ARRANGE
        Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
                .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

        Long customerId = 1L;

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        // ACT
        Customer retrievedCustomer = customerService.getCustomer(customerId);

        // ASSERT
        assertEquals(customer, retrievedCustomer);
    }

    @Test
    public void getCustomerNotFound() {
        // ARRANGE
        Long customerId = 1L;
        // Mock retrieving a customer that does not exist
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        // ACT & ASSERT
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(customerId));
    }
}
