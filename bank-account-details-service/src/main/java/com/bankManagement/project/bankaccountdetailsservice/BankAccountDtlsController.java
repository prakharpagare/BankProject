package com.bankManagement.project.bankaccountdetailsservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankManagement.project.bankaccountdetailsservice.bankAccDetailsDataObject.BankAccDtlsEntity;
import com.bankManagement.project.bankaccountdetailsservice.bankAccRepo.BankAccDetailsRepo;
import com.bankManagement.project.bankaccountdetailsservice.proxy.UserDetailsServiceProxy;

@RestController
public class BankAccountDtlsController {
	
	@Autowired
	private BankAccDetailsRepo bankAccDetailsRepo;
	
	@Autowired
	private UserDetailsServiceProxy userDetailsServiceProxy;
	
	@GetMapping("/bankAccDetails")
	public List<BankAccDtlsEntity> getAllBankAccountDetails(){
		return bankAccDetailsRepo.findAll();
	}
	
	@GetMapping("/bankAccDetails/bank-acc-no/{bankAccNo}")
	public BankAccDtlsEntity getAllBankAccountDetailsByBankAccNumber(@PathVariable String bankAccNo){
		return bankAccDetailsRepo.findByBankAccNo(bankAccNo);
	}
	 
	@GetMapping("/bankAccDetails/bank-acc-no/{bankAccNo}/ifsc-code/{ifscCode}")
	public BankAccDtlsEntity getAllBankAccountDetailsByBankAccNumberandIfsc(@PathVariable String bankAccNo,@PathVariable String ifscCode){
		return bankAccDetailsRepo.findByBankAccNoAndIfscCode(bankAccNo,ifscCode);
	}
	
	@PostMapping("/bankAccDetails/bank-acc-no/")
	public void createNewBankAccount(@RequestBody BankAccDtlsEntity bankAccDtlsEntity){
		bankAccDetailsRepo.save(bankAccDtlsEntity);
	}
	
	@PutMapping("/bankAccDetails/bank-acc-no/{bankAccNo}")
	public void updateBankAccDetails(@PathVariable String bankAccNo,@RequestBody BankAccDtlsEntity bankAccDtlsEntity){
		BankAccDtlsEntity oldDetails = bankAccDetailsRepo.findByBankAccNo(bankAccNo);
		if(oldDetails != null) {
			oldDetails.setBalance(bankAccDtlsEntity.getBalance());
		}
		userDetailsServiceProxy.updateBankDetailsForUser(oldDetails);
		bankAccDetailsRepo.save(oldDetails);
	}
}
