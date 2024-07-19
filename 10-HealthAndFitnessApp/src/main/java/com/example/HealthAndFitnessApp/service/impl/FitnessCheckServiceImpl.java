package com.example.HealthAndFitnessApp.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.HealthAndFitnessApp.commonresponse.CommonResponse;
import com.example.HealthAndFitnessApp.dto.FitnessCheckDTO;
import com.example.HealthAndFitnessApp.model.FitnessCheckResult;
import com.example.HealthAndFitnessApp.repository.FItnessCheckRepo;
import com.example.HealthAndFitnessApp.service.IFitnessCheck;

@Service
@Transactional
public class FitnessCheckServiceImpl implements IFitnessCheck {

    @Autowired
    private FItnessCheckRepo fitnessCheckRepository;

    @Override
    public CommonResponse add(FitnessCheckDTO fitnessDto) {
    
    	
    	FitnessCheckResult block = new FitnessCheckResult();
		BeanUtils.copyProperties(fitnessDto, block);
		fitnessCheckRepository.save(block);
		fitnessDto.setId(block.getId()); // Set the ID in the DTO after saving
		return new CommonResponse("success", "201", fitnessDto);
    }

    @Override
    public CommonResponse findById(UUID id) {
        try {
            Optional<FitnessCheckResult> fitnessOptional = fitnessCheckRepository.findById(id);
            if (fitnessOptional.isPresent()) {
            	FitnessCheckResult fitnessCheck = fitnessOptional.get();
                FitnessCheckDTO fitnessDto = new FitnessCheckDTO();
                BeanUtils.copyProperties(fitnessCheck, fitnessDto);
                return new CommonResponse("Fitness check found", "200", fitnessDto);
            } else {
                return new CommonResponse("Fitness check not found", "404");
            }
        } catch (Exception e) {
            return new CommonResponse("Error finding fitness check: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse findAll() {
        try {
            List<FitnessCheckResult> fitnessChecks = fitnessCheckRepository.findAll();
            List<FitnessCheckDTO> fitnessDtoList = fitnessChecks.stream()
                    .map(fitnessCheck -> {
                        FitnessCheckDTO fitnessDto = new FitnessCheckDTO();
                        BeanUtils.copyProperties(fitnessCheck, fitnessDto);
                        return fitnessDto;
                    })
                    .collect(Collectors.toList());
            return new CommonResponse("All fitness checks retrieved successfully", "200", fitnessDtoList);
        } catch (Exception e) {
            return new CommonResponse("Error retrieving fitness checks: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse update(UUID id, FitnessCheckDTO fitnessDto) {
        try {
            Optional<FitnessCheckResult> existingFitnessOptional = fitnessCheckRepository.findById(id);
            if (existingFitnessOptional.isPresent()) {
            	FitnessCheckResult existingFitness = existingFitnessOptional.get();
                BeanUtils.copyProperties(fitnessDto, existingFitness);
                existingFitness.setId(id); // Ensure the ID is not changed
                FitnessCheckResult updatedFitness = fitnessCheckRepository.save(existingFitness);
                FitnessCheckDTO updatedFitnessDto = new FitnessCheckDTO();
                BeanUtils.copyProperties(updatedFitness, updatedFitnessDto);
                return new CommonResponse("Fitness check updated successfully", "200", updatedFitnessDto);
            } else {
                return new CommonResponse("Fitness check not found", "404");
            }
        } catch (Exception e) {
            return new CommonResponse("Error updating fitness check: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse delete(UUID id) {
        try {
            if (fitnessCheckRepository.existsById(id)) {
                fitnessCheckRepository.deleteById(id);
                return new CommonResponse("Fitness check deleted successfully", "200");
            } else {
                return new CommonResponse("Fitness check not found", "404");
            }
        } catch (Exception e) {
            return new CommonResponse("Error deleting fitness check: " + e.getMessage(), "500");
        }
    }
}
