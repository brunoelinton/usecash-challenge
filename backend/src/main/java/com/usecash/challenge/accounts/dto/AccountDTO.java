package com.usecash.challenge.accounts.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.usecash.challenge.entities.Account;

public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private BigDecimal balance;
	
	public AccountDTO() {
	}

	public AccountDTO(Long id, String name, BigDecimal balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public AccountDTO(Account entity) {
		id = entity.getId();
		name = entity.getName();
		balance = entity.getBalance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
