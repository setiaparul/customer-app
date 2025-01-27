package org.allica.system.customerapp;

import org.allica.system.customerapp.controller.CustomerAppController;
import org.allica.system.customerapp.entity.Customer;
import org.allica.system.customerapp.exceptions.CustomerCreationFailureException;
import org.allica.system.customerapp.models.CustomerRequest;
import org.allica.system.customerapp.models.ResponseDto;
import org.allica.system.customerapp.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerAppController customerController;

    private CustomerRequest validCustomerRequest;
    private UUID testUuid;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUuid = UUID.randomUUID();
        validCustomerRequest = new CustomerRequest(
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
    }

    @Test
    void createCustomer_Success() throws CustomerCreationFailureException {
        // Arrange
        when(customerService.addCustomer(any(CustomerRequest.class)))
                .thenReturn(testUuid.toString());

        // Act
        ResponseEntity<ResponseDto<String>> response =
                customerController.createCustomer(validCustomerRequest);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testUuid.toString(), response.getBody().getData());
        assertEquals(201, response.getBody().getStatus());
    }

    @Test
    void createCustomer_Failure() throws CustomerCreationFailureException {
        // Arrange
        when(customerService.addCustomer(any(CustomerRequest.class)))
                .thenThrow(new CustomerCreationFailureException("Creation failed", 500));

        // Act & Assert
        assertThrows(CustomerCreationFailureException.class, () ->
                customerController.createCustomer(validCustomerRequest));
    }

    @Test
    void getCustomerDetails_Success() {
        // Arrange
        Customer customer = new Customer("John", "Doe", LocalDate.of(1990, 1, 1));
        ResponseDto<Customer> expectedResponse = new ResponseDto<>(
                customer,
                "Customer retrieved successfully",
                200
        );
        when(customerService.fetchCustomerById(any(UUID.class)))
                .thenReturn(expectedResponse);

        // Act
        ResponseDto<Customer> response = customerController.getCustomerDetails(testUuid);

        // Assert
        assertNotNull(response);
        assertEquals(expectedResponse.getData(), response.getData());
        assertEquals(200, response.getStatus());
    }
}

