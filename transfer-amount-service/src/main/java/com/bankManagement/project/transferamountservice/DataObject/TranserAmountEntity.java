package com.bankManagement.project.transferamountservice.DataObject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TranserAmountEntity {
	
	@Id
	@GeneratedValue
	private Long tId;
	private String fromBankAcc;
	private String toBankAcc;
	private BigDecimal amt;
	
	protected TranserAmountEntity() {
		
	}
	
	public TranserAmountEntity(Long tId, String fromBankAcc, String toBankAcc, BigDecimal amt) {
		super();
		this.tId = tId;
		this.fromBankAcc = fromBankAcc;
		this.toBankAcc = toBankAcc;
		this.amt = amt;
	}
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getFromBankAcc() {
		return fromBankAcc;
	}
	public void setFromBankAcc(String fromBankAcc) {
		this.fromBankAcc = fromBankAcc;
	}
	public String getToBankAcc() {
		return toBankAcc;
	}
	public void setToBankAcc(String toBankAcc) {
		this.toBankAcc = toBankAcc;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	
}
