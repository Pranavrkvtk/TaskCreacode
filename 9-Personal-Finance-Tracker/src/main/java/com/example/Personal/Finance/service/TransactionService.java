package com.example.Personal.Finance.service;

import com.example.Personal.Finance.commonResponse.CommonResponse;
import com.example.Personal.Finance.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionService {
    
    CommonResponse addTransaction(Transaction transaction);
    
    CommonResponse updateTransaction(Transaction transaction);
    
    Optional<Transaction> getTransactionById(UUID id);
    
    List<Transaction> getAllTransactions();
    
    CommonResponse deleteTransaction(UUID id);
}
