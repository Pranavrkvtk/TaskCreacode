package com.example.GroupMangementSystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GroupMangementSystem.Entity.Rack;


@Repository
public interface IRackRepository extends JpaRepository<Rack,UUID>{

}
