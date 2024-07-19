package com.example.HealthAndFitnessApp.service;

import java.util.UUID;

import com.example.HealthAndFitnessApp.commonresponse.CommonResponse;
import com.example.HealthAndFitnessApp.dto.UserDto;

public interface IUserService {
    
    CommonResponse add(UserDto user);
    
    CommonResponse findById(UUID id);
    
    CommonResponse findAll();
    
    CommonResponse update(UUID id, UserDto user);
    
    CommonResponse delete(UUID id);
}
