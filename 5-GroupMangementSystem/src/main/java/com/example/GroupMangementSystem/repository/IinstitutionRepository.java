package com.example.GroupMangementSystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GroupMangementSystem.Entity.Institution;

public interface IinstitutionRepository extends JpaRepository<Institution, UUID> {

}
