package com.example.GroupMangementSystem.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.dto.InstitutionDto;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.service.IInstitutionService;

@RestController
@RequestMapping("/institutions")
public class InstitutionController {

    @Autowired
    private IInstitutionService institutionService;

    @PostMapping
    public ResponseEntity<CommonResponse<InstitutionDto>> createInstitution(@RequestBody InstitutionDto institutionDto) {
        CommonResponse<InstitutionDto> response = institutionService.create(institutionDto);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<InstitutionDto>> updateInstitution(@PathVariable UUID id, @RequestBody InstitutionDto institutionDto) {
        CommonResponse<InstitutionDto> response = institutionService.update(id, institutionDto);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<InstitutionDto>> getInstitutionById(@PathVariable UUID id) {
        CommonResponse<InstitutionDto> response = institutionService.getById(id);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<InstitutionDto>>> getAllInstitutions() {
        CommonResponse<List<InstitutionDto>> response = institutionService.getAll();
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<String>> deleteInstitution(@PathVariable UUID id) {
        CommonResponse<String> response = institutionService.delete(id);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @PostMapping("/{institutionId}/colleges")
    public ResponseEntity<CommonResponse<College>> addCollegeToInstitution(@PathVariable UUID institutionId, @RequestBody College college) {
        CommonResponse<College> response = institutionService.addCollegeToInstitution(institutionId, college);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @DeleteMapping("/{institutionId}/colleges/{collegeId}")
    public ResponseEntity<CommonResponse<String>> removeCollegeFromInstitution(@PathVariable UUID institutionId, @PathVariable UUID collegeId) {
        CommonResponse<String> response = institutionService.removeCollegeFromInstitution(institutionId, collegeId);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }

    @GetMapping("/{institutionId}/colleges")
    public ResponseEntity<CommonResponse<List<College>>> getCollegesByInstitutionId(@PathVariable UUID institutionId) {
        CommonResponse<List<College>> response = institutionService.getCollegesByInstitutionId(institutionId);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
    }
    
    @PostMapping("/{institutionId}/colleges/bulk")
    public ResponseEntity<CommonResponse<List<College>>> addCollegesToInstitution(
            @PathVariable UUID institutionId,
            @RequestBody List<College> colleges) {

        CommonResponse<List<College>> response = institutionService.addCollegesToInstitution(institutionId, colleges);

        return ResponseEntity
                .status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())))
                .body(response);
    }

}
