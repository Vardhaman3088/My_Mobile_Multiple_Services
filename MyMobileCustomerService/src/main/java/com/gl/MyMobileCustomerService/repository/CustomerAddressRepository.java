package com.gl.MyMobileCustomerService.repository;

import com.gl.MyMobileCustomerService.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
}
