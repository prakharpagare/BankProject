package com.bankManagement.project.bankaccountdetailsservice.bankAccRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankManagement.project.bankaccountdetailsservice.bankAccDetailsDataObject.BankAccDtlsEntity;

@Repository
public interface BankAccDetailsRepo extends JpaRepository<BankAccDtlsEntity, Integer>{
//	@Query("SELECT t FROM BankAccDtlsEntity t where t.bankAccNo = ?1")
	public BankAccDtlsEntity findByBankAccNo(String bankAccNo); 
	
	public BankAccDtlsEntity findByBankAccNoAndIfscCode(String bankAccNo, String ifscCode); 
}
