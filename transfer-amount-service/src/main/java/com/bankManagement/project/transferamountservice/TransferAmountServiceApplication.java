package com.bankManagement.project.transferamountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.bankManagement.project.*")
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class TransferAmountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferAmountServiceApplication.class, args);
	}

}
