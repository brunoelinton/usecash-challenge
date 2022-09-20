package com.usecash.challenge.accounts.dto;

import java.math.BigDecimal;

public class DepositDTO {

	private Long idAccount;
	private BigDecimal amount;
	
	public DepositDTO() {
	}

	public DepositDTO(Long idAccount, BigDecimal amount) {
		this.idAccount = idAccount;
		this.amount = amount;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
