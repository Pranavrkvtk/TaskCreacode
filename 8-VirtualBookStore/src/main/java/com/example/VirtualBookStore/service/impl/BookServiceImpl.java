package com.example.VirtualBookStore.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VirtualBookStore.model.Books;
import com.example.VirtualBookStore.repository.IBookRepository;
import com.example.VirtualBookStore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	
	@Autowired
	private IBookRepository dao;

	@Override
	public Books saveBooks(Books books) {
		return dao.save(books);
	}

	@Override
	public Books getBooksById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
