package com.example.StudentManagementSystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.StudentManagementSystem.model.StudentDetails;

import jakarta.transaction.Transactional;

public interface IStudentRepository extends JpaRepository<StudentDetails, UUID> {

	public StudentDetails findByName(String name);

	public List<StudentDetails> findByGender(String Gender);

	public List<StudentDetails> findByAge(int age);

	public StudentDetails findByFatherName(String name);

	public StudentDetails findByMotherName(String name);

	public List<StudentDetails> findByAddress(String address);

	@Transactional
	@Modifying
	@Query(value = "UPDATE studentdetails SET name = ?1, adm_no = ?2, roll_no = ?3, address = ?4, gender = ?5, father_name = ?6, mother_name = ?7, age = ?8, height = ?9, weight = ?10, dob = ?11, phone = ?12, father_designation = ?13, mother_designation = ?14 WHERE id = ?15", nativeQuery = true)
	int updateStudentData(String name, String admNo, int rollNo, String address, String gender, String fatherName,
			String motherName, int age, double height, double weight, String dob, String phone,
			String fatherDesignation, String motherDesignation, UUID id);
}
