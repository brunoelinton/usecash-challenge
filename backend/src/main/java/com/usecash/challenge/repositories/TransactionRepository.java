package com.usecash.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecash.challenge.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
