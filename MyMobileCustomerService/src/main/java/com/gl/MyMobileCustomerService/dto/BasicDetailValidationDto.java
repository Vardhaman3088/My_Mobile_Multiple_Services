package com.gl.MyMobileCustomerService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BasicDetailValidationDto {

     @NotNull(message = "email address is mandatory field")
     @Email
     @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$",message = "Enter correct email address of format abc@gmai.com")
     private String emailAddress;

    @NotNull(message = "Date Of Birth is mandatory field")
    private String dateOfBirth;

    public BasicDetailValidationDto(String emailAddress, String dateOfBirth) {
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
    }

    public BasicDetailValidationDto() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "BasicDetailValidationDto{" +
                "emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
