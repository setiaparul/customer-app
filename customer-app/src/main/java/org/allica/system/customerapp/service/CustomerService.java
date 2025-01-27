package org.allica.system.customerapp.service;


import org.allica.system.customerapp.entity.Customer;
import org.allica.system.customerapp.exceptions.CustomerCreationFailureException;
import org.allica.system.customerapp.exceptions.CustomerNotFoundException;
import org.allica.system.customerapp.models.CustomerRequest;
import org.allica.system.customerapp.models.ResponseDto;
import org.allica.system.customerapp.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final ICustomerRepo customerRepo;

    public CustomerService(@Qualifier("imMemoryCustomerRepo")
                           @Autowired ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    public String addCustomer(CustomerRequest customerRequest) throws CustomerCreationFailureException {
        try {
            Customer customer = new Customer(
                    customerRequest.getFirstName(),
                    customerRequest.getLastName(),
                    customerRequest.getDateOfBirth()
            );
            customerRepo.add(customer);
            return customer.getId().toString();
        } catch (Exception e) {
            throw new CustomerCreationFailureException("Customer creation failed", 500);
        }
    }


    public ResponseDto<Customer> fetchCustomerById(UUID id) {
        Optional<Customer> customerOptional = customerRepo.get(id);

        if (customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }

        return new ResponseDto<>(
                customerOptional.get(),
                "Customer retrieved successfully",
                200
        );
    }
}