package com.example.Personal.Finance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Personal.Finance.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{

}
