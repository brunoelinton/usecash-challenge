package com.usecash.challenge.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usecash.challenge.accounts.dto.AccountDTO;
import com.usecash.challenge.entities.Account;
import com.usecash.challenge.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	@Transactional(readOnly = true)
	public List<AccountDTO> findAll() {
		List<Account> list = repository.findAll();

		return list.stream().map(acc -> new AccountDTO(acc)).collect(Collectors.toList());
	}

	@Transactional
	public AccountDTO insert(AccountDTO dto) {
		Account entity = new Account();
		entity.setName(dto.getName());
		entity.setName(dto.getCpf());
		
		entity = repository.save(entity);
		return new AccountDTO(entity);
	}
}
