package com.bankManagement.project.bankaccountdetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages="com.bankManagement.project.*")
@SpringBootApplication
public class BankAccountDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountDetailsServiceApplication.class, args);
	}

}
