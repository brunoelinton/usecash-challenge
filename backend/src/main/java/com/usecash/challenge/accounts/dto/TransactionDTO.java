package com.usecash.challenge.accounts.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.usecash.challenge.entities.Account;
import com.usecash.challenge.entities.Transaction;
import com.usecash.challenge.entities.enums.StatusTransaction;

public class TransactionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Account origin;
	private Account destiny;
	private BigDecimal amount;
	private Integer status;
	
	public TransactionDTO() {
	}

	public TransactionDTO(Long id, Account origin, Account destiny, BigDecimal amount, StatusTransaction status) {
		this.id = id;
		this.origin = origin;
		this.destiny = destiny;
		this.amount = amount;
		setStatus(status);
	}
	
	public TransactionDTO(Transaction entity) {
		id = entity.getId();
		origin = entity.getOrigin();
		destiny = entity.getDestiny();
		amount = entity.getAmount();
		status = entity.getStatus().getCode();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getOrigin() {
		return origin;
	}

	public void setOrigin(Account origin) {
		this.origin = origin;
	}

	public Account getDestiny() {
		return destiny;
	}

	public void setDestiny(Account destiny) {
		this.destiny = destiny;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public StatusTransaction getStatus() {
		return StatusTransaction.valueOf(status);
	}

	public void setStatus(StatusTransaction status) {
		if (status != null)
			this.status = status.getCode();
	}
}
