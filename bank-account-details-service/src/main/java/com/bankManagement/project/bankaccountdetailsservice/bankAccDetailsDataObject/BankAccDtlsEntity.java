package com.bankManagement.project.bankaccountdetailsservice.bankAccDetailsDataObject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT_DTLS")
public class BankAccDtlsEntity {
	
	@Id
	@GeneratedValue
	private Integer bankAccId;
	private String bankAccNo;
	private String ifscCode;
	private BigDecimal balance;
	
	public BankAccDtlsEntity() {
		
	}
	
	public BankAccDtlsEntity(Integer bankAccId, String bankAccNo, String ifscCode, BigDecimal balance) {
		super();
		this.bankAccId = bankAccId;
		this.bankAccNo = bankAccNo;
		this.ifscCode = ifscCode;
		this.balance = balance;
	}
	public Integer getBankAccId() {
		return bankAccId;
	}
	public void setBankAccId(Integer bankAccId) {
		this.bankAccId = bankAccId;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
