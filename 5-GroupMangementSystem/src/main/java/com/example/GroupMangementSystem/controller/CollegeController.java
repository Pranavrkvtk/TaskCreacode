package com.example.GroupMangementSystem.controller;

import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.CollegeDTO;
import com.example.GroupMangementSystem.service.ICollegeService;
import com.example.GroupMangementSystem.service.IInstitutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	private ICollegeService collegeService;
	
	@PostMapping("/create")
	public ResponseEntity<CommonResponse> createCollege(@RequestBody CollegeDTO collegeDTO) {
		CommonResponse response = collegeService.create(collegeDTO);
		return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommonResponse> updateCollege(@PathVariable UUID id, @RequestBody CollegeDTO collegeDTO) {
		CommonResponse response = collegeService.update(id, collegeDTO);
		return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommonResponse> getCollegeById(@PathVariable UUID id) {
		CommonResponse response = collegeService.getById(id);
		return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
	}

	@GetMapping
	public ResponseEntity<CommonResponse> getAllColleges() {
		CommonResponse response = collegeService.getAll();
		return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommonResponse> deleteCollege(@PathVariable UUID id) {
		CommonResponse response = collegeService.delete(id);
		return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
	}

}
