package com.example.GroupMangementSystem.service;

import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.RackDto;

import java.util.List;
import java.util.UUID;

public interface IRackService {
    CommonResponse create(RackDto rack);

    CommonResponse update(UUID id, RackDto rack);

    CommonResponse getById(UUID id);

    CommonResponse getAll();

    CommonResponse delete(UUID id);
    
    CommonResponse<List<Book>> addBooksToRack(UUID rackUUID, List<Book> Books);
}
