package com.example.AttendanceManagemetSystem.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AttendanceManagemetSystem.commonresponse.CommonResponse;
import com.example.AttendanceManagemetSystem.model.StudentDetails;
import com.example.AttendanceManagemetSystem.service.impl.StudentServiceImpl;

import jakarta.annotation.PostConstruct;

@RestController

@RequestMapping("/api/studentattendance")
public class Controller {
	
	@Autowired
	private StudentServiceImpl sercie;
	

	    @Autowired
	    private StudentServiceImpl studentService;

	    @PostMapping
	    public CommonResponse addStudent(@RequestBody StudentDetails studentDetails) {
	        return studentService.add(studentDetails);
	    }

	    @GetMapping("/{id}")
	    public StudentDetails getStudentById(@PathVariable UUID id) {
	        return studentService.getById(id);
	    }

	    @GetMapping
	    public List<StudentDetails> getAllStudents() {
	        return studentService.getAll();
	    }

	    @PutMapping("/{id}")
	    public CommonResponse updateStudent(@PathVariable UUID id, @RequestBody StudentDetails studentDetails) {
	        studentDetails.setId(id); // Set the ID from path variable to the studentDetails object
	        return studentService.update(studentDetails);
	    }

	    @DeleteMapping("/{id}")
	    public CommonResponse deleteStudent(@PathVariable UUID id) {
	        return studentService.delete(id);
	    }

}
