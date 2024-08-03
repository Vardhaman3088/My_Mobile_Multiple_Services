package com.gl.MyMobileCustomerService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonalDetailValidationDto {
    @NotNull(message = "firstName cannot be null")
    @Size(max = 15, message = "The FirstName Should be less than 15 character long")
    private String firstName;
    @NotNull(message = "LastName cannot be null")
    @Size(max = 15, message = "The LastName should be less than 15 character long ")
    private String lastname;
    private String confirmEmail;

    public PersonalDetailValidationDto(String firstName, String lastname, String confirmEmail) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.confirmEmail = confirmEmail;
    }

    public PersonalDetailValidationDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    @Override
    public String toString() {
        return "PersonalDetailValidationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", confirmEmail='" + confirmEmail + '\'' +
                '}';
    }
}
