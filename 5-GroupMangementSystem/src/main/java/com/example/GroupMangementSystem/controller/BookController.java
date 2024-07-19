package com.example.GroupMangementSystem.controller;

import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.BookDto;
import com.example.GroupMangementSystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public ResponseEntity<CommonResponse> createBook(@RequestBody BookDto bookDto) {
        CommonResponse response = bookService.create(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateBook(
            @PathVariable UUID id,
            @RequestBody BookDto bookDto) {
        CommonResponse response = bookService.update(id, bookDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getBookById(@PathVariable UUID id) {
        CommonResponse response = bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllBooks() {
        CommonResponse response = bookService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteBook(@PathVariable UUID id) {
        CommonResponse response = bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("rack/{rackId}/books/bulk")
    public ResponseEntity<CommonResponse<List<Book>>> addBooksToRack(
            @PathVariable UUID rackId,
            @RequestBody List<Book> books) {

        CommonResponse<List<Book>> response = bookService.addBooksToRack(rackId, books);

        return ResponseEntity
                .status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())))
                .body(response);
  }
}