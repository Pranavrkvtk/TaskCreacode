package com.example.Personal.Finance.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Personal.Finance.commonResponse.CommonResponse;
import com.example.Personal.Finance.model.Transaction;
import com.example.Personal.Finance.repository.TransactionRepository;
import com.example.Personal.Finance.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository dao;

    @Override
    public CommonResponse addTransaction(Transaction transaction) {
        try {
            dao.save(transaction);
            return new CommonResponse("SUCCESS", "Transaction added successfully.",transaction);
        } catch (Exception e) {
            return new CommonResponse("FAILURE", "Error adding transaction: " + e.getMessage());
        }
    }

    @Override
    public CommonResponse updateTransaction(Transaction transaction) {
        try {
            if (dao.existsById(transaction.getId())) {
                dao.save(transaction);
                return new CommonResponse("SUCCESS", "Transaction updated successfully.");
            } else {
                return new CommonResponse("FAILURE", "Transaction not found.");
            }
        } catch (Exception e) {
            return new CommonResponse("FAILURE", "Error updating transaction: " + e.getMessage());
        }
    }

    @Override
    public Optional<Transaction> getTransactionById(UUID id) {
        return dao.findById(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return dao.findAll();
    }

    @Override
    public CommonResponse deleteTransaction(UUID id) {
        try {
            if (dao.existsById(id)) {
                dao.deleteById(id);
                return new CommonResponse("SUCCESS", "Transaction deleted successfully.");
            } else {
                return new CommonResponse("FAILURE", "Transaction not found.");
            }
        } catch (Exception e) {
            return new CommonResponse("FAILURE", "Error deleting transaction: " + e.getMessage());
        }
    }
}
