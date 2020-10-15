package com.bankManagement.project.userservice.DataObject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue
	private Long uId;
	private String userName;
	private String bankAccNo;
	private String ifscCode;
	private BigDecimal balance;
	
	public UserDetails() {
		
	}
	
	public UserDetails(Long uId, String userName, String bankAccNo, String ifscCode, BigDecimal balance) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.bankAccNo = bankAccNo;
		this.ifscCode = ifscCode;
		this.balance = balance;
	}
	
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getbankAccNo() {
		return bankAccNo;
	}
	public void setbankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public BigDecimal getbalance() {
		return balance;
	}
	public void setbalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
