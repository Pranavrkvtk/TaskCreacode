package com.example.GroupMangementSystem.service.impl;

import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.Rack;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.BookDto;
import com.example.GroupMangementSystem.repository.IBookRepository;
import com.example.GroupMangementSystem.repository.IRackRepository;
import com.example.GroupMangementSystem.service.IBookService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;
    
    @Autowired
    private IRackRepository rackRepository;

    @Override
    public CommonResponse<BookDto> create(BookDto dto) {
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        bookRepository.save(book);
        dto.setId(book.getId());
        return new CommonResponse("success", "201", dto);
    }

    @Override
    public CommonResponse<BookDto> update(UUID id, BookDto dto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return new CommonResponse("failure", "404", "Book not found");
        }

        Book book = optionalBook.get();
        BeanUtils.copyProperties(dto, book);
        book.setId(id);
        bookRepository.save(book);

        return new CommonResponse("success", "200", dto);
    }

    @Override
    public CommonResponse<BookDto> getById(UUID id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return new CommonResponse("failure", "404", "Book not found");
        }

        Book book = optionalBook.get();
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(book, dto);
        return new CommonResponse("success", "200", dto);
    }

    @Override
    public CommonResponse<List<BookDto>> getAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> dtos = books.stream()
                .map(book -> {
                    BookDto dto = new BookDto();
                    BeanUtils.copyProperties(book, dto);
                    return dto;
                })
                .collect(Collectors.toList());

        return new CommonResponse("success", "200", dtos);
    }

    @Override
    public CommonResponse<String> delete(UUID id) {
        if (!bookRepository.existsById(id)) {
            return new CommonResponse("failure", "404", "Book not found");
        }

        bookRepository.deleteById(id);
        return new CommonResponse("success", "200", "Book deleted successfully");
    }

    @Override
    @Transactional
    public CommonResponse<List<Book>> addBooksToRack(UUID rackId, List<Book> books) {
        Optional<Rack> rackOptional = rackRepository.findById(rackId);
        if (!rackOptional.isPresent()) {
            return new CommonResponse("failure", "404", "Rack not found");
        }

        Rack rack = rackOptional.get();
        for (Book book : books) {
            book.setRack(rack);
            bookRepository.save(book);
        }

        return new CommonResponse("success", "201", books);
    }

    
}
