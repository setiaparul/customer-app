package org.allica.system.customerapp.controller;


import jakarta.validation.Valid;
import org.allica.system.customerapp.entity.Customer;
import org.allica.system.customerapp.exceptions.CustomerCreationFailureException;
import org.allica.system.customerapp.models.CustomerRequest;
import org.allica.system.customerapp.models.ResponseDto;
import org.allica.system.customerapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerAppController {

    private CustomerService customerService;

    public CustomerAppController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<String>> createCustomer(@Valid @RequestBody CustomerRequest customerRequest)
            throws CustomerCreationFailureException {
        String customerId = customerService.addCustomer(customerRequest);
        ResponseDto<String> response = new ResponseDto<>(
                customerId,
                "Customer created successfully",
                201
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{customerId}")
    public ResponseDto<Customer> getCustomerDetails(@PathVariable("customerId") UUID customerId) {
        return customerService.fetchCustomerById(customerId);
    }

}
