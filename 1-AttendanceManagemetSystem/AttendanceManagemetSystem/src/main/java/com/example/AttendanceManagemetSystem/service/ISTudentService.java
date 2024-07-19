package com.example.AttendanceManagemetSystem.service;

import com.example.AttendanceManagemetSystem.commonresponse.CommonResponse;
import com.example.AttendanceManagemetSystem.model.StudentDetails;

import java.util.List;
import java.util.UUID;

public interface ISTudentService<T> {
    CommonResponse add(StudentDetails g);  // Create operation

    StudentDetails getById(UUID id);       // Read operation

    List<StudentDetails> getAll();         // Read operation

    CommonResponse update(StudentDetails g);  // Update operation

    CommonResponse delete(UUID id);       // Delete operation
}
