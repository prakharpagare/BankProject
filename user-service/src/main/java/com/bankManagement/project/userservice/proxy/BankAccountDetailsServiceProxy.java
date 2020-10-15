package com.bankManagement.project.userservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankManagement.project.userservice.DataObject.UserDetails;

//@FeignClient(name="bank-account-details-service", url = "http://localhost:8000")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="bank-account-details-service")
public interface BankAccountDetailsServiceProxy {
//	@PostMapping("/bankAccDetails/bank-acc-no/")
	@PostMapping("/bank-account-details-service/bankAccDetails/bank-acc-no/")
	public void createNewBankAccount(UserDetails user);
}
