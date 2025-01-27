package org.allica.system.customerapp.repo;

import java.util.Optional;
import java.util.UUID;

public interface ICustomerRepo<T> {

    void add(T object);

    Optional<T> get(UUID id);


}
