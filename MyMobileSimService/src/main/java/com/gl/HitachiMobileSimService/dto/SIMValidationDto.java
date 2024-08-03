package com.gl.HitachiMobileSimService.dto;

import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.Range;

public class SIMValidationDto {
    @Range(min = 1000000000L,max=9999999999L,message = "Service Number should of exactly 10 digits.")
    private long serviceNumber;
    @Range(min = 100000000000L,max=999999999999L,message = "Sim Number should of exactly 13 digits.")
    private long simNumber;

    public SIMValidationDto(long serviceNumber, long simNumber) {
        this.serviceNumber = serviceNumber;
        this.simNumber = simNumber;
    }

    public SIMValidationDto() {
    }

    @Digits(integer = 10, fraction = 0, message = "The service number must have at most 10 digits")
    public long getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(@Digits(integer = 10, fraction = 0, message = "The service number must have at most 10 digits") long serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @Digits(integer = 13, fraction = 0, message = "The service number must have at most 13 digits")
    public long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(@Digits(integer = 13, fraction = 0, message = "The service number must have at most 13 digits") long simNumber) {
        this.simNumber = simNumber;
    }

    @Override
    public String toString() {
        return "SIMValidationDto{" +
                "serviceNumber=" + serviceNumber +
                ", simNumber=" + simNumber +
                '}';
    }
}
