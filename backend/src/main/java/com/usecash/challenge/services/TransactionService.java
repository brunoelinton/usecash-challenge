package com.usecash.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usecash.challenge.accounts.dto.TransactionDTO;
import com.usecash.challenge.entities.Transaction;
import com.usecash.challenge.repositories.TransactionRepository;
import com.usecash.challenge.services.exceptions.DatabaseException;
import com.usecash.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	@Transactional(readOnly = true)
	public List<TransactionDTO> findAll() {
		List<Transaction> list = repository.findAll();
		return list.stream().map(acc -> new TransactionDTO(acc)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public TransactionDTO findById(Long id) {
		Optional<Transaction>  obj = repository.findById(id);
		Transaction entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TransactionDTO(entity);
	}
	
	@Transactional
	public TransactionDTO insert(TransactionDTO dto) {		
		try {
			Transaction entity = new Transaction();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new TransactionDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(TransactionDTO dto, Transaction entity) {
		entity.setOrigin(dto.getOrigin());
		entity.setDestiny(dto.getDestiny());
		entity.setAmount(dto.getAmount());
	}
}
