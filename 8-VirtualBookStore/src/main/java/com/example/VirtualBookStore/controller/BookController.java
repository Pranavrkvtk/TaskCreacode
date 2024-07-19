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

import com.example.VirtualBookStore.model.Books;
import com.example.VirtualBookStore.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable UUID id) {

		Books book = service.getBooksById(id);
		return ResponseEntity.ok(book);
	}

	@PostMapping("/post")
	public ResponseEntity<Books> createBook(@RequestBody Books book) {
		Books savedBook = service.saveBooks(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}

}
