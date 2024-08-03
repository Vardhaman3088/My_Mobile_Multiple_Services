package com.gl.MyMobileCustomerService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerIdentity {
    @Id
    private long uniqueIdNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String state;

    public CustomerIdentity(long uniqueIdNumber, String dateOfBirth, String emailAddress, String firstName, String lastName, String state) {
        this.uniqueIdNumber = uniqueIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }

    public CustomerIdentity() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomerIdentity{" +
                "uniqueIdNumber=" + uniqueIdNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
