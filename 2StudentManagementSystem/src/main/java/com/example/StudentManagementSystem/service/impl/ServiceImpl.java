package com.example.StudentManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.commonResponse.CommonResponse;
import com.example.StudentManagementSystem.model.StudentDetails;
import com.example.StudentManagementSystem.repository.IStudentRepository;
import com.example.StudentManagementSystem.requestDto.RequestDto;
import com.example.StudentManagementSystem.service.IBaseService;
import com.example.StudentManagementSystem.service.IStudentService;

@Service
public class ServiceImpl implements IStudentService {

	@Autowired

	private IStudentRepository dao;

	@Override
	public CommonResponse AddData(RequestDto dto) {
		// TODO Auto-generated method stub

		StudentDetails data = new StudentDetails();

		BeanUtils.copyProperties(dto, data);

		dao.save(data);
		return new CommonResponse("success", "201", dto);
	}

	@Override
	public CommonResponse searchId(UUID id) {
		// TODO Auto-generated method stub

		Optional<StudentDetails> optional = dao.findById(id);

		RequestDto dto = new RequestDto();

		if (optional.isPresent()) {

			StudentDetails data = optional.get();
			BeanUtils.copyProperties(data, dto);

		}

		return new CommonResponse(" datad found success", "202", dto);
	}

	@Override
	public CommonResponse SearchName(String name) {

		Optional<StudentDetails> Optional = java.util.Optional.ofNullable(dao.findByName(name));

		RequestDto dto = new RequestDto();

		if (Optional.isPresent()) {

			StudentDetails data = Optional.get();
			BeanUtils.copyProperties(data, dto);

		}

		// TODO Auto-generated method stub
		return new CommonResponse("success", "202", dto);
	}

	@Override
	public CommonResponse SearchFatherName(String name) {
		// TODO Auto-generated method stub

		Optional<StudentDetails> Optional = java.util.Optional.ofNullable(dao.findByFatherName(name));

		RequestDto dto = new RequestDto();

		if (Optional.isPresent()) {

			StudentDetails data = Optional.get();
			BeanUtils.copyProperties(data, dto);

		}
		return new CommonResponse("success", "201", dto);
	}

	@Override
	public CommonResponse SearchMotherName(String name) {
		// TODO Auto-generated method stub

		Optional<StudentDetails> Optional = java.util.Optional.ofNullable(dao.findByMotherName(name));

		RequestDto dto = new RequestDto();

		if (Optional.isPresent()) {
			StudentDetails data = Optional.get();

			BeanUtils.copyProperties(data, dto);

		}
		return new CommonResponse("Success", "201", dto);
	}

	@Override
	public List<StudentDetails> findByAge(int age) {
		// TODO Auto-generated method stub
		return dao.findByAge(age);
	}

	@Override
	public List<StudentDetails> findByAddress(String address) {
		return (List<StudentDetails>) dao.findByAddress(address);
	}

	@Override
	public int updateStudentDetails(UUID id, StudentDetails updatedStudentDetails) {
		// TODO Auto-generated method stub
	     return dao.updateStudentData(
	                updatedStudentDetails.getName(),
	                updatedStudentDetails.getAdmNo(),
	                updatedStudentDetails.getRollNo(),
	                updatedStudentDetails.getAddress(),
	                updatedStudentDetails.getGender(),
	                updatedStudentDetails.getFatherName(),
	                updatedStudentDetails.getMotherName(),
	                updatedStudentDetails.getAge(),
	                updatedStudentDetails.getHeight(),
	                updatedStudentDetails.getWeight(),
	                updatedStudentDetails.getDob(),
	                updatedStudentDetails.getPhone(),
	                updatedStudentDetails.getFatherDesgnation(),
	                updatedStudentDetails.getMotherDesignation(),
	                id
	        );

	
	
	
	
	}

	
}
