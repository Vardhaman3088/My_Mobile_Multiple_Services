package com.gl.MyMobileCustomerService.dto;

import com.gl.MyMobileCustomerService.entity.Customer;

public class CustomerWithSimDetailsAndOffers {
    Customer customer;
    private SimOffers simOffers;

    public CustomerWithSimDetailsAndOffers(Customer customer, SimOffers simOffers) {
        this.customer = customer;
        this.simOffers = simOffers;
    }

    public CustomerWithSimDetailsAndOffers() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SimOffers getSimOffers() {
        return simOffers;
    }

    public void setSimOffers(SimOffers simOffers) {
        this.simOffers = simOffers;
    }

    @Override
    public String toString() {
        return "CustomerWithSimDetailsAndOffers{" +
                "customer=" + customer +
                ", simOffers=" + simOffers +
                '}';
    }
}
