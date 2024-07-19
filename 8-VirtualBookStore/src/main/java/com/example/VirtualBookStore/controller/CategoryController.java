package com.example.VirtualBookStore.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VirtualBookStore.model.Category;
import com.example.VirtualBookStore.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	

    @PostMapping("/category") 
    public ResponseEntity<Category> createOrder(@RequestBody Category order) {
    	Category savedOrder = service.savecategory(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
	    

}
