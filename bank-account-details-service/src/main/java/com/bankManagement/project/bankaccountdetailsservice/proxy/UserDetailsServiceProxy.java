package com.bankManagement.project.bankaccountdetailsservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bankManagement.project.bankaccountdetailsservice.bankAccDetailsDataObject.BankAccDtlsEntity;

//@FeignClient(name = "user-details-service", url = "http://localhost:8080")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "user-service")
public interface UserDetailsServiceProxy {

	@PutMapping("/user-details-service/users")
	public void updateBankDetailsForUser(@RequestBody BankAccDtlsEntity user);
}
