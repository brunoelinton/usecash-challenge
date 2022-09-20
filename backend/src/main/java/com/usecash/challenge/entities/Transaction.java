package com.usecash.challenge.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.usecash.challenge.entities.enums.StatusTransaction;

@Entity
@Table(name = "TB_TRANSACTION")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ORIGIN_ID")
	private Account origin;
	
	@OneToOne
	@JoinColumn(name = "DESTINY_ID")
	private Account destiny;
	
	private BigDecimal amount;
	@Column(columnDefinition = "integer default 1")
	private Integer status = 1;
	
	public Transaction() {
	}

	public Transaction(Long id, Account origin, Account destiny, BigDecimal amount, StatusTransaction status) {
		this.id = id;
		this.origin = origin;
		this.destiny = destiny;
		this.amount = amount;
		setStatus(status);
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}
}
