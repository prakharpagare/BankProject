package com.bankManagement.project.transferamountservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankManagement.project.transferamountservice.proxy.TransactionServiceProxy;

@RestController
public class TransferAmountController {
	
	@Autowired
	TransactionServiceProxy txnServiceProxy;
	
	@GetMapping("/tranferAmount/from/{fromAcc}/to/{toAcc}/amount/{amt}")
	public void doTransferAmount(@PathVariable String fromAcc, @PathVariable String toAcc, @PathVariable BigDecimal amt) {
		txnServiceProxy.doCredit(toAcc, amt);
		txnServiceProxy.doDebit(fromAcc, amt);
	}
}
