package com.gl.MyMobileCustomerService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    private long uniqueIdNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String idType;
    @OneToOne
    private CustomerAddress customerAddress;
    private Integer simId;
    private String state;

    public Customer(long uniqueIdNumber, String dateOfBirth, String emailAddress, String firstName, String lastName, String idType, CustomerAddress customerAddress, Integer simId, String state) {
        this.uniqueIdNumber = uniqueIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idType = idType;
        this.customerAddress = customerAddress;
        this.simId = simId;
        this.state = state;
    }

    public Customer() {
    }

    public long getUniqueIdNumber() {
        return uniqueIdNumber;
    }

    public void setUniqueIdNumber(long uniqueIdNumber) {
        this.uniqueIdNumber = uniqueIdNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getSimId() {
        return simId;
    }

    public void setSimId(Integer simId) {
        this.simId = simId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uniqueIdNumber=" + uniqueIdNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idType='" + idType + '\'' +
                ", customerAddress=" + customerAddress +
                ", simId=" + simId +
                ", state='" + state + '\'' +
                '}';
    }
}
