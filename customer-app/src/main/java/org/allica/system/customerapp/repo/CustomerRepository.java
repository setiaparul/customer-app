package org.allica.system.customerapp.repo;

import org.allica.system.customerapp.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository("imMemoryCustomerRepo")
public class CustomerRepository implements ICustomerRepo<Customer> {

    Map<UUID, Customer> customerMap ;

    public CustomerRepository() {
        this .customerMap = new ConcurrentHashMap<>();
    }


    @Override
    public void add(Customer customer) {
        if(!ObjectUtils.isEmpty(customer)) {
            customerMap.put(customer.getId(),customer);
        }
    }

    @Override
    public Optional<Customer> get(UUID id) {
        return Optional.ofNullable(customerMap.get(id));
    }
}
