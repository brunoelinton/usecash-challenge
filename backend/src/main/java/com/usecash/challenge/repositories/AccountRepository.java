package com.usecash.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecash.challenge.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
