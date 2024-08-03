package com.gl.MyMobileCustomerService.exception;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
}
