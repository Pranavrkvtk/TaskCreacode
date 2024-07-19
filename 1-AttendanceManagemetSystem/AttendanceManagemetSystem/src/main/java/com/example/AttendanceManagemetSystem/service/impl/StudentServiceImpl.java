package com.example.AttendanceManagemetSystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AttendanceManagemetSystem.commonresponse.CommonResponse;
import com.example.AttendanceManagemetSystem.model.StudentDetails;
import com.example.AttendanceManagemetSystem.repository.IStudentRepository;
import com.example.AttendanceManagemetSystem.service.ISTudentService;

@Service
public class StudentServiceImpl implements ISTudentService<StudentDetails> {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public CommonResponse add(StudentDetails studentDetails) {
        studentRepository.save(studentDetails);
        return new CommonResponse("Student added successfully", "201");
    }

    @Override
    public StudentDetails getById(UUID id) {
        Optional<StudentDetails> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public List<StudentDetails> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public CommonResponse update(StudentDetails studentDetails) {
        if (studentDetails.getId() == null) {
            throw new IllegalArgumentException("Student ID cannot be null for update");
        }
        studentRepository.save(studentDetails);
        return new CommonResponse("Student updated successfully", "202");
    }

	@Override
	public CommonResponse delete(UUID id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
        return new CommonResponse("Student updated successfully", "202");
	}

}
