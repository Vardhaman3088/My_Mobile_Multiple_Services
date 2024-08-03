package com.gl.MyMobileCustomerService.repository;

import com.gl.MyMobileCustomerService.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity, Long> {
}
