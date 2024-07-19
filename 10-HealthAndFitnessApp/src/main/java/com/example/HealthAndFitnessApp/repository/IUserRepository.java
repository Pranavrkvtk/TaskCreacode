package com.example.HealthAndFitnessApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HealthAndFitnessApp.model.User;

public interface IUserRepository extends JpaRepository<User, UUID>{

}
