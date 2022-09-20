package com.usecash.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usecash.challenge.accounts.dto.AccountDTO;
import com.usecash.challenge.accounts.dto.DepositDTO;
import com.usecash.challenge.entities.Account;
import com.usecash.challenge.repositories.AccountRepository;
import com.usecash.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	@Transactional(readOnly = true)
	public List<AccountDTO> findAll() {
		List<Account> list = repository.findAll();
		return list.stream().map(acc -> new AccountDTO(acc)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AccountDTO findById(Long id) {
		Optional<Account>  obj = repository.findById(id);
		Account entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AccountDTO(entity);
	}
	
	@Transactional
	public AccountDTO insert(AccountDTO dto) {
		Account entity = new Account();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity = repository.save(entity);
		return new AccountDTO(entity);
	}
	
	@Transactional
	public AccountDTO update(Long id, AccountDTO dto) {
		try {
			Account entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity = repository.save(entity);
			return new AccountDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}
	
	@Transactional
	public AccountDTO depositAccount(DepositDTO dto) {
		try {
			Account entity = repository.getReferenceById(dto.getIdAccount());
			entity.deposit(dto.getAmount());
			entity = repository.save(entity);
			return new AccountDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + dto.getIdAccount());
		}
	}
}
