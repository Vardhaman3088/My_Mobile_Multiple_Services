package com.gl.MyMobileCustomerService.service;

import com.gl.MyMobileCustomerService.client.SimClient;
import com.gl.MyMobileCustomerService.dto.*;
import com.gl.MyMobileCustomerService.entity.Customer;
import com.gl.MyMobileCustomerService.entity.CustomerAddress;
import com.gl.MyMobileCustomerService.exception.CustomerNotFound;
import com.gl.MyMobileCustomerService.repository.CustomerAddressRepository;
import com.gl.MyMobileCustomerService.repository.CustomerIdentityRepository;
import com.gl.MyMobileCustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    SimClient simClient;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Autowired
    CustomerIdentityRepository customerIdentityRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public String validateBasicDetails(BasicDetailValidationDto basicDetailvalidationDto) {
        Optional<Customer> customer = customerRepository.findByEmailAddressAndDateOfBirth(basicDetailvalidationDto.getEmailAddress(), basicDetailvalidationDto.getDateOfBirth());
        if(customer.isPresent()){
            return "Validated Successfully";
        }else{
            return "No request placed for you.";
        }

    }

    @Override
    public String validatePersonalDetails(PersonalDetailValidationDto personalDetailValidationDto) {
        Optional<Customer> customer = customerRepository.findByFirstNameAndLastName(personalDetailValidationDto.getFirstName(), personalDetailValidationDto.getLastname());

        if(!customer.isPresent())
            return "Given FirstName and Last Name is not present in the table";

        System.out.println(customer.get().getEmailAddress());
        System.out.println(personalDetailValidationDto.getConfirmEmail());

        if(customer.get().getEmailAddress().equals(personalDetailValidationDto.getConfirmEmail())){
            return "Email Address validated Succefully";
        }else{
            return  "Email Address is not Validated Successfully";
        }
    }

    @Override
    public CustomerAddress customerAddressValidation(CustomerAddress customerAddress, Integer uniqueId) {
        customerAddressRepository.save(customerAddress);
        return customerAddress;
    }

    @Override
    public String customerIdentityValidation(CustomeridentityDto customeridentityDto) {
        long givenid = customeridentityDto.getUniqueIdNumber();
        String givenDOB = customeridentityDto.getDateOfBirth();
        String givenFirstName = customeridentityDto.getFirstName();
        String givenLastName = customeridentityDto.getLastName();
        String givenState = customeridentityDto.getState();
        String givenEmail = customeridentityDto.getEmailAddress();
        String givenIdType = customeridentityDto.getId_type();

        System.out.println("Heyyyyyyyyyyy,"+givenIdType);


        Optional<Customer> cust = customerRepository.findById(givenid);
        if(!cust.isPresent()){
            return "Details are wroung";
        }else if(givenDOB.equals(cust.get().getDateOfBirth()) && givenFirstName.equals(cust.get().getFirstName()) && givenLastName.equals(cust.get().getLastName()) && givenState.equals(cust.get().getState()) && givenEmail.equals(cust.get().getEmailAddress()) && givenIdType.equals(cust.get().getIdType())){
            return "Details are validated";
        }else {
            return "Details are wrong";
        }
    }

    @Override
    public String ShowOrderinfo(Long uniqueid){
        Optional<Customer> customer= customerRepository.findById(uniqueid);
        Integer simId = customer.get().getSimId();
        SimDetails simDetails = simClient.ShowDetailsWithId(simId).getBody();
        String offer = simClient.ShowOfferWithId(simId).getBody();

        return customer.get().toString() +" /n Sim-Details: "+simDetails.toString() + "/n Sim-Offer:- "+offer;
    }

    @Override
    public CustomerWithSimDetailsAndOffers showAllOrder(Long uniqueId){
        Optional<Customer> customer = customerRepository.findById(uniqueId);
        if(!customer.isPresent()){
            throw  new CustomerNotFound("The customer with given Id does not found");
        }
        SimOffers simOffers = simClient.ShowOfferObjectWithId(customer.get().getSimId()).getBody();

        return new CustomerWithSimDetailsAndOffers(customer.get(), simOffers);
    }


//    @Override
//    public CustomerAddress customerAddressValidation(CustomerAddress customerAddress, int uniqueId) {
//        customerAddressRepository.save(customerAddress);
//        return customerAddress;
//    }


}
