package com.example.VirtualBookStore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.example.VirtualBookStore.model.Books;

@Repository
public interface IBookRepository extends JpaRepository<Books,UUID>{

}
