package com.bankManagement.project.transactionservice.repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankManagement.project.transactionservice.DataObject.TransactionEntity;

@Repository
public interface TransactionServiceRepo extends JpaRepository<TransactionEntity, Integer>{
	
	@Query(
			  value = "SELECT * FROM TRANSACTION_ENTITY U WHERE U.BANK_ACC_NO = ?1", 
			  nativeQuery = true)
	public TransactionEntity findByBankAccNo(String bankAccNo);
}
