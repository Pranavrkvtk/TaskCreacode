package com.example.GroupMangementSystem.service;

import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Institution;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.BookDto;

import java.util.List;
import java.util.UUID;

public interface IBookService {

    CommonResponse create(BookDto dto);

    CommonResponse update(UUID id, BookDto dto);

    CommonResponse getById(UUID id);

    CommonResponse getAll();

    CommonResponse delete(UUID id);
    
    CommonResponse<List<Book>> addBooksToRack(UUID rackId, List<Book> books);

}
