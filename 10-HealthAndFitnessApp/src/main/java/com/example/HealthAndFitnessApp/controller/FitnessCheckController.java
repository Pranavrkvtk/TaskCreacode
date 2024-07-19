package com.example.HealthAndFitnessApp.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.HealthAndFitnessApp.commonresponse.CommonResponse;
import com.example.HealthAndFitnessApp.dto.FitnessCheckDTO;
import com.example.HealthAndFitnessApp.service.IFitnessCheck;

@RestController
@RequestMapping("/api/fitness-checks")
public class FitnessCheckController {

    @Autowired
    private IFitnessCheck fitnessCheckService;

    @PostMapping
    public ResponseEntity<CommonResponse> addFitnessCheck(@RequestBody FitnessCheckDTO fitnessDto) {
        CommonResponse response = fitnessCheckService.add(fitnessDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getFitnessCheckById(@PathVariable UUID id) {
        CommonResponse response = fitnessCheckService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllFitnessChecks() {
        CommonResponse response = fitnessCheckService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateFitnessCheck(@PathVariable UUID id, @RequestBody FitnessCheckDTO fitnessDto) {
        CommonResponse response = fitnessCheckService.update(id, fitnessDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteFitnessCheck(@PathVariable UUID id) {
        CommonResponse response = fitnessCheckService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
