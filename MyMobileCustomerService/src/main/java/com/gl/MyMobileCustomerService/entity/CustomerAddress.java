package com.gl.MyMobileCustomerService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class CustomerAddress {

    @Id
    private int addresId;

    @Size(max = 25, message = "The length of the address cannot be more than 25")
    private String address;
    @Pattern(regexp = "^[a-zA-Z ]+$" , message = "The city must not be contain the character other than space")
    private String city;
    @Min(value = 100000, message = "The pincode must be 6 digit long")
    @Max(value = 1000000, message = "The pincode must be 6 digit long")
    private int pinCode;
    private String state;

    public CustomerAddress(int addresId, String address, String city, int pinCode, String state) {
        this.addresId = addresId;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

    public CustomerAddress() {
    }

    public int getAddresId() {
        return addresId;
    }

    public void setAddresId(int addresId) {
        this.addresId = addresId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "addresId=" + addresId +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                '}';
    }
}
