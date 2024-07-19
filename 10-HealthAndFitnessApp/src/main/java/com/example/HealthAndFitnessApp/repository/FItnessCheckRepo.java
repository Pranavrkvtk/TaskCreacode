package com.example.HealthAndFitnessApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HealthAndFitnessApp.dto.FitnessCheckDTO;
import com.example.HealthAndFitnessApp.model.FitnessCheckResult;

@Repository
public interface FItnessCheckRepo extends JpaRepository<FitnessCheckResult, UUID> {

}
