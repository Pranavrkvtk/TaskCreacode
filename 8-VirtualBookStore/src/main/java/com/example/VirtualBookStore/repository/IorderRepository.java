package com.example.VirtualBookStore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualBookStore.model.BookOrder;

public interface IorderRepository extends JpaRepository<BookOrder, UUID> {

}
