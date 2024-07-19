package com.example.GroupMangementSystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GroupMangementSystem.Entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,UUID> {

}
