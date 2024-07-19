package com.example.GroupMangementSystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GroupMangementSystem.Entity.College;

@Repository
public interface ICollegeRepository extends JpaRepository<College, UUID>{


}
