package com.usecash.challenge.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecash.challenge.accounts.dto.AccountDTO;
import com.usecash.challenge.services.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountResource {

	@Autowired
	private AccountService service;
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> findAll() {
		List<AccountDTO> list = service.findAll();
		
		// List<AccountDTO> list = new ArrayList<>();
		
		return ResponseEntity.ok().body(list);
	}
}
