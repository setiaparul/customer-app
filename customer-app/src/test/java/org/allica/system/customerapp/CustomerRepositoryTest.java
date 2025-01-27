package org.allica.system.customerapp;


import org.allica.system.customerapp.entity.Customer;
import org.allica.system.customerapp.repo.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private CustomerRepository customerRepository;
    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepository();
        testCustomer = new Customer(
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
    }

    @Test
    void add_Success() {
        // Act
        customerRepository.add(testCustomer);

        // Assert
        Optional<Customer> retrievedCustomer = customerRepository.get(testCustomer.getId());
        assertTrue(retrievedCustomer.isPresent());
        assertEquals(testCustomer, retrievedCustomer.get());
    }

    @Test
    void get_CustomerNotFound() {
        // Act
        Optional<Customer> retrievedCustomer = customerRepository.get(UUID.randomUUID());

        // Assert
        assertTrue(retrievedCustomer.isEmpty());
    }

    @Test
    void add_UpdateExistingCustomer() {
        // Arrange
        customerRepository.add(testCustomer);
        Customer updatedCustomer = new Customer(
                "Jane",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
        updatedCustomer.setId(testCustomer.getId());

        // Act
        customerRepository.add(updatedCustomer);

        // Assert
        Optional<Customer> retrievedCustomer = customerRepository.get(testCustomer.getId());
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("Jane", retrievedCustomer.get().getFirstName());
    }
}