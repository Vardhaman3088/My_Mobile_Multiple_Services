package com.gl.MyMobileCustomerService.service;

import com.gl.MyMobileCustomerService.dto.BasicDetailValidationDto;
import com.gl.MyMobileCustomerService.dto.CustomerWithSimDetailsAndOffers;
import com.gl.MyMobileCustomerService.dto.CustomeridentityDto;
import com.gl.MyMobileCustomerService.dto.PersonalDetailValidationDto;
import com.gl.MyMobileCustomerService.entity.CustomerAddress;

public interface CustomerService {
    String validateBasicDetails(BasicDetailValidationDto basicDetailvalidationDto);

    String validatePersonalDetails(PersonalDetailValidationDto personalDetailValidationDto);

    CustomerAddress customerAddressValidation(CustomerAddress customerAddress, Integer uniqueId);

    String customerIdentityValidation(CustomeridentityDto customeridentityDto);

    String ShowOrderinfo(Long uniqueid);

    CustomerWithSimDetailsAndOffers showAllOrder(Long uniqueId);
}
