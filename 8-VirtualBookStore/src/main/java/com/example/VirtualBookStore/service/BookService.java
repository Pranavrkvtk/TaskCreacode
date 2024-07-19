package com.example.VirtualBookStore.service;

import java.util.UUID;

import com.example.VirtualBookStore.model.Books;

public interface BookService {
	Books saveBooks(Books books);

    Books getBooksById(UUID id);

}
