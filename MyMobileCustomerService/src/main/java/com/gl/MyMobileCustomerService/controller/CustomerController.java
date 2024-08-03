package com.gl.MyMobileCustomerService.controller;

import com.gl.MyMobileCustomerService.dto.BasicDetailValidationDto;
import com.gl.MyMobileCustomerService.dto.CustomerWithSimDetailsAndOffers;
import com.gl.MyMobileCustomerService.dto.CustomeridentityDto;
import com.gl.MyMobileCustomerService.dto.PersonalDetailValidationDto;
import com.gl.MyMobileCustomerService.entity.CustomerAddress;
import com.gl.MyMobileCustomerService.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping("/validateBasicdetails")
    public ResponseEntity<String> validateCustomerBasicDetails(@Valid @RequestBody BasicDetailValidationDto basicDetailvalidationDto) {
        String res = customerService.validateBasicDetails(basicDetailvalidationDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/validatePersonalDetails")
    public ResponseEntity<String> validateCustomerPersonalDetails(@Valid @RequestBody PersonalDetailValidationDto personalDetailValidationDto) {

        String res = customerService.validatePersonalDetails(personalDetailValidationDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/updateAddress/{uniqueId}")
    public ResponseEntity<CustomerAddress> updateCustomerAddress(@Valid @RequestBody CustomerAddress customerAddress, @PathVariable Integer uniqueId) {
        customerService.customerAddressValidation(customerAddress, uniqueId);
        return new ResponseEntity<>(customerAddress, HttpStatus.OK);
    }
    @PostMapping("/validateIdentity")
    public ResponseEntity<String> validateCustomerIdentity(@RequestBody CustomeridentityDto customeridentityDto) {

        String res = customerService.customerIdentityValidation(customeridentityDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/OrderInfo/{uniqueid}")
    public String ShowOrderinfo(@PathVariable Long uniqueid){
        return customerService.ShowOrderinfo(uniqueid);
    }

    @GetMapping("/Order/{uniqueid}")
    public ResponseEntity<CustomerWithSimDetailsAndOffers> showAllOrder(@PathVariable Long uniqueid){
        CustomerWithSimDetailsAndOffers customerWithSimDetailsAndOffers =   customerService.showAllOrder(uniqueid);
        return new ResponseEntity<>(customerWithSimDetailsAndOffers, HttpStatus.OK);
    }


}
