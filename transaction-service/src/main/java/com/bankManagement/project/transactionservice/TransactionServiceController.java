package com.bankManagement.project.transactionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankManagement.project.transactionservice.DataObject.TransactionEntity;
import com.bankManagement.project.transactionservice.proxy.BankAccountDetailsServiceProxy;
import com.bankManagement.project.transactionservice.repo.TransactionServiceRepo;

@RestController
public class TransactionServiceController {

	@Autowired
	TransactionServiceRepo txnServiceRepo;
	
	@Autowired
	BankAccountDetailsServiceProxy bankAccDtlsProxy;

	public TransactionEntity getBalance(String bankAccNo) {
		return bankAccDtlsProxy.getAllBankAccountDetailsByBankAccNumber(bankAccNo);
	}

	@GetMapping("/balance/bank-account-number/{bankAccNo}/debit/{amt}")
	public void doDebit(@PathVariable String bankAccNo,@PathVariable BigDecimal amt) {
		TransactionEntity balanceEntity = this.getBalance(bankAccNo);
		BigDecimal balance = balanceEntity.getBalance();
		if (balance != null && balance.compareTo(BigDecimal.ZERO) > 0
				&& balance.subtract(amt).compareTo(BigDecimal.ZERO) > 0) {
			balance = balance.subtract(amt);
		}
		TransactionEntity txnEntity = new TransactionEntity();
		txnEntity.setBankAccNo(bankAccNo);
		txnEntity.setBalance(balance);
		txnEntity.setTxnType(Integer.valueOf(2));
		txnEntity.setAmt(amt);
		txnServiceRepo.save(txnEntity);
		txnEntity.setTxnType(null);
		txnEntity.setAmt(null);
		txnEntity.setTxnId(null);
		bankAccDtlsProxy.updateBankAccDetails(bankAccNo, txnEntity);
	}

	@GetMapping("/balance/bank-account-number/{bankAccNo}/credit/{amt}")
	public void doCredit(@PathVariable String bankAccNo, @PathVariable BigDecimal amt) {
		TransactionEntity balanceEntity = this.getBalance(bankAccNo);
		BigDecimal balance = balanceEntity.getBalance();
		balance = balance.add(amt);
		TransactionEntity txnEntity = new TransactionEntity();
		txnEntity.setBankAccNo(bankAccNo);
		txnEntity.setBalance(balance);
		txnEntity.setTxnType(Integer.valueOf(1));
		
		txnServiceRepo.save(txnEntity);
		txnEntity.setTxnType(null);
		txnEntity.setAmt(null);
		txnEntity.setTxnId(null);
		bankAccDtlsProxy.updateBankAccDetails(bankAccNo, txnEntity);
	}

}
