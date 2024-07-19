package com.example.AttendanceManagemetSystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AttendanceManagemetSystem.model.StudentDetails;


@Repository
public interface IStudentRepository  extends JpaRepository<StudentDetails,UUID>{

}
