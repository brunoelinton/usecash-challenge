package com.usecash.challenge.accounts;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<AccountDTO> insertAccount(@RequestBody AccountDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(dto.getId())
					.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
