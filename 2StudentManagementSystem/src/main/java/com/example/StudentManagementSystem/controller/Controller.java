package com.example.StudentManagementSystem.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementSystem.commonResponse.CommonResponse;
import com.example.StudentManagementSystem.model.StudentDetails;
import com.example.StudentManagementSystem.requestDto.RequestDto;
import com.example.StudentManagementSystem.service.IStudentService;

@RestController
public class Controller {

	@Autowired
	private IStudentService service;
	
	@PostMapping("/post")
	public CommonResponse AddData(@RequestBody RequestDto dto) {
	
		CommonResponse data= service.AddData(dto);
		
		return data;
		
	}
	
	@GetMapping("/get-by-id")
	public  CommonResponse GEtByid(@RequestParam ("id") UUID id) {
		
		CommonResponse response=service.searchId(id);
		return response;
		
	}

	
	
	@GetMapping("/get-by-name")
	public  CommonResponse GEtByname(@RequestParam ("name") String name) {
		
		CommonResponse response=service.SearchName(name);
		return response;
		
	}
	@GetMapping("/get-by-fathername")
	public CommonResponse getByFatherName(@RequestParam ("name")String name) {
		CommonResponse response = service.SearchFatherName(name);
		return response;
	}
	@GetMapping("/get-by-Motherrname")
	public CommonResponse getByMotherName(@RequestParam ("name")String name) {
		CommonResponse response = service.SearchMotherName(name);
		return response;
	}
	
	@GetMapping("/students/age/{age}")
    public List<StudentDetails> getStudentsByAge(@PathVariable int age) {
        return service.findByAge(age);
    }
	
	@GetMapping("/students/address")
    public List<StudentDetails> getStudentsByAddress(@RequestParam ("addres") String address) {
        return service.findByAddress(address);
    }

	 @PutMapping("/{id}")
	    public ResponseEntity<Void> updateStudentDetails(@PathVariable UUID id, @RequestBody StudentDetails studentDetails) {
	        int updateCount = service.updateStudentDetails(id, studentDetails);
	        if (updateCount > 0) {
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }

}}
