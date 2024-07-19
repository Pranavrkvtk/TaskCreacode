package com.example.GroupMangementSystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GroupMangementSystem.Entity.Floor;

public interface IFloorRepository extends JpaRepository<Floor,UUID> {

}
