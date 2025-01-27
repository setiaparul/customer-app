package org.allica.system.customerapp;



import org.allica.system.customerapp.exceptions.CustomerNotFoundException;
import org.allica.system.customerapp.repo.ICustomerRepo;
import org.allica.system.customerapp.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Mock
    private ICustomerRepo customerRepo;

    @InjectMocks
    private CustomerService customerService;

    private org.allica.system.customerapp.models.CustomerRequest validCustomerRequest;
    private org.allica.system.customerapp.entity.Customer validCustomer;
    private UUID testUuid;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUuid = UUID.randomUUID();
        validCustomerRequest = new org.allica.system.customerapp.models.CustomerRequest(
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
        validCustomer = new org.allica.system.customerapp.entity.Customer(
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
    }

    @Test
    void addCustomer_Success() throws org.allica.system.customerapp.exceptions.CustomerCreationFailureException {
        // Arrange
        doNothing().when(customerRepo).add(any(org.allica.system.customerapp.entity.Customer.class));

        // Act
        String customerId = customerService.addCustomer(validCustomerRequest);

        // Assert
        assertNotNull(customerId);
        verify(customerRepo, times(1)).add(any(org.allica.system.customerapp.entity.Customer.class));
    }

    @Test
    void addCustomer_FailureOnRepoException() {
        // Arrange
        doThrow(new RuntimeException("Database error"))
                .when(customerRepo).add(any(org.allica.system.customerapp.entity.Customer.class));

        // Act & Assert
        assertThrows(org.allica.system.customerapp.exceptions.CustomerCreationFailureException.class, () ->
                customerService.addCustomer(validCustomerRequest));
        verify(customerRepo, times(1)).add(any(org.allica.system.customerapp.entity.Customer.class));
    }

    @Test
    void fetchCustomerById_Success() {
        // Arrange
        when(customerRepo.get(testUuid))
                .thenReturn(Optional.of(validCustomer));

        // Act
        org.allica.system.customerapp.models.ResponseDto<org.allica.system.customerapp.entity.Customer> response = customerService.fetchCustomerById(testUuid);

        // Assert
        assertNotNull(response);
        assertEquals(validCustomer, response.getData());
        assertEquals(200, response.getStatus());
        verify(customerRepo, times(1)).get(testUuid);
    }

    @Test
    void fetchCustomerById_CustomerNotFound() {
        // Arrange
        when(customerRepo.get(testUuid))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CustomerNotFoundException.class, () ->
                customerService.fetchCustomerById(testUuid));
        verify(customerRepo, times(1)).get(testUuid);
    }
}