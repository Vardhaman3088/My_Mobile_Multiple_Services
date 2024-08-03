package com.gl.MyMobileCustomerService.repository;

import com.gl.MyMobileCustomerService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailAddressAndDateOfBirth(String emailAddress, String dateOfBirth);

    Optional<Customer> findByFirstNameAndLastName(String firstName, String LastName);

    Optional<Customer> findByFirstNameAndLastNameAndEmailAddress(String firstName, String LastName, String EmailAddress);

}
