package com.example.StudentManagementSystem.service;

import java.util.List;
import java.util.UUID;

import com.example.StudentManagementSystem.commonResponse.CommonResponse;
import com.example.StudentManagementSystem.model.StudentDetails;

public interface IBaseService<T> {

	public CommonResponse AddData(T dto);

	public CommonResponse searchId(UUID id);

	public CommonResponse SearchName(String name);

	public CommonResponse SearchFatherName(String name);

	public CommonResponse SearchMotherName(String name);

	public List<StudentDetails> findByAge(int age);



	
    int updateStudentDetails(UUID id, StudentDetails updatedStudentDetails);

	List<StudentDetails> findByAddress(String address);

}
