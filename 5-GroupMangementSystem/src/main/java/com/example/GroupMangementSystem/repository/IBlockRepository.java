package com.example.GroupMangementSystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GroupMangementSystem.Entity.Block;

public interface IBlockRepository  extends JpaRepository<Block, UUID>{

}
