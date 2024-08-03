package com.gl.MyMobileCustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.gl.MyMobileCustomerService.client")
public class MyMobileCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMobileCustomerServiceApplication.class, args);
	}

}
