package com.example.HealthAndFitnessApp.service;

import java.util.UUID;

import com.example.HealthAndFitnessApp.commonresponse.CommonResponse;
import com.example.HealthAndFitnessApp.dto.FitnessCheckDTO;
import com.example.HealthAndFitnessApp.dto.UserDto;

public interface IFitnessCheck {
	 
    CommonResponse add(FitnessCheckDTO fitness);
    
    CommonResponse findById(UUID id);
    
    CommonResponse findAll();
    
    CommonResponse update(UUID id, FitnessCheckDTO  fitness);
    
    CommonResponse delete(UUID id);

}
