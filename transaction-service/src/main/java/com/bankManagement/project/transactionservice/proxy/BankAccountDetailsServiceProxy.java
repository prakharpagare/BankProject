package com.bankManagement.project.transactionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bankManagement.project.transactionservice.DataObject.TransactionEntity;

//@FeignClient(name="bank-account-details-service",url = "http://localhost:8000")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="bank-account-details-service")
public interface BankAccountDetailsServiceProxy {
	
	@GetMapping("/bank-account-details-service/bankAccDetails/bank-acc-no/{bankAccNo}")
	public TransactionEntity getAllBankAccountDetailsByBankAccNumber(@PathVariable("bankAccNo") String bankAccNo);
	
	@GetMapping("/bank-account-details-service/bankAccDetails/bank-acc-no/{bankAccNo}/ifsc-code/{ifscCode}")
	public TransactionEntity getAllBankAccountDetailsByBankAccNumberandIfsc(@PathVariable("bankAccNo") String bankAccNo,@PathVariable("ifscCode") String ifscCode);

	@PutMapping("/bank-account-details-service/bankAccDetails/bank-acc-no/{bankAccNo}")
	public void updateBankAccDetails(@PathVariable("bankAccNo") String bankAccNo,@RequestBody TransactionEntity bankAccDtlsEntity);
	
}
