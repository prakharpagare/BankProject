package com.bankManagement.project.transferamountservice.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(name="transaction-service", url = "http://localhost:8100")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="transaction-service")
public interface TransactionServiceProxy {
	
//	@GetMapping("/balance/bank-account-number/{bankAccNo}/debit/{amt}")
	@GetMapping("/transaction-service/balance/bank-account-number/{bankAccNo}/debit/{amt}")
	public void doDebit(@PathVariable("bankAccNo") String bankAccNo, @PathVariable("amt") BigDecimal amt);
	
//	@GetMapping("/balance/bank-account-number/{bankAccNo}/credit/{amt}")
	@GetMapping("/transaction-service/balance/bank-account-number/{bankAccNo}/credit/{amt}")
	public void doCredit(@PathVariable("bankAccNo") String bankAccNo,@PathVariable("amt") BigDecimal amt);
}
