package com.example.VirtualBookStore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VirtualBookStore.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, UUID> {

}
