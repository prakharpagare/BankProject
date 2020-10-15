package com.bankManagement.project.transactionservice.DataObject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class TransactionEntity {
	
	@Id
	@GeneratedValue
	private Integer txnId;
	private String bankAccNo;
	private BigDecimal amt;
	private BigDecimal balance;
	private Integer txnType; // 1 for credit, 2 for debit
	private Integer bankAccId;
	

	public TransactionEntity() {
		
	}
	
	public TransactionEntity(Integer txnId, String bankAccNo, BigDecimal amt, BigDecimal balance,Integer txnType,Integer bankAccId) {
		super();
		this.txnId = txnId;
		this.bankAccNo = bankAccNo;
		this.amt = amt;
		this.balance = balance;
		this.txnType = txnType;
		this.bankAccId = bankAccId;
	}
	
	public Integer getTxnId() {
		return txnId;
	}
	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getTxnType() {
		return txnType;
	}
	public void setTxnType(Integer txnType) {
		this.txnType = txnType;
	}

	public Integer getBankAccId() {
		return bankAccId;
	}

	public void setBankAccId(Integer bankAccId) {
		this.bankAccId = bankAccId;
	}
}
