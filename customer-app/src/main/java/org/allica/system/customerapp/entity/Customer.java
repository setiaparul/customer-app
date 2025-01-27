package org.allica.system.customerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
public class Customer {
    public Customer(String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    private UUID id;

    private String firstName;

    private String lastName;

    LocalDate dateOfBirth;
}
