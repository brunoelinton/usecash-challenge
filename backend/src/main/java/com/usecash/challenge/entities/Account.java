package com.usecash.challenge.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private BigDecimal balance;
	
	public Account() {
	}

	public Account(Long id, String name, String cpf, BigDecimal balance) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.balance = balance;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public boolean deposit(BigDecimal amount) {
		if (amount.compareTo(new BigDecimal(0.0)) <= 0) 
			return false;		
		
		balance = balance.add(amount);
		System.out.println("depositou");
		return true;
	}
	
	public boolean withdraw(BigDecimal amount) {
		if (amount.compareTo(balance) == 1) 
			return false;
		
		balance = balance.subtract(amount);
		return true;		
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
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
