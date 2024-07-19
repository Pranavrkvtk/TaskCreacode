package com.example.Personal.Finance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Personal.Finance.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}
