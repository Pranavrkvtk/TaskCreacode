package com.example.Personal.Finance.controller;

import java.util.List;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Personal.Finance.commonResponse.CommonResponse;
import com.example.Personal.Finance.model.Transaction;
import com.example.Personal.Finance.service.TransactionService;
import com.example.Personal.Finance.service.impl.TransactionServiceImpl;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl service;
	


	    @PostMapping("/add")
	    public ResponseEntity<CommonResponse> addTransaction(@RequestBody Transaction transaction) {
	        CommonResponse response = service.addTransaction(transaction);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<CommonResponse> updateTransaction(@RequestBody Transaction transaction) {
	        CommonResponse response = service.updateTransaction(transaction);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	

	    @GetMapping("/all")
	    public ResponseEntity<List<Transaction>> getAllTransactions() {
	        List<Transaction> transactions = service.getAllTransactions();
	        return new ResponseEntity<>(transactions, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<CommonResponse> deleteTransaction(@PathVariable UUID id) {
	        CommonResponse response = service.deleteTransaction(id);
	        if (response.getStatuscode().equals("SUCCESS")) {
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	        }
	    }
	}



