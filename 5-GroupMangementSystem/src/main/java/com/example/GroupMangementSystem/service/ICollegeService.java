package com.example.GroupMangementSystem.service;

import java.util.UUID;

import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.CollegeDTO;

public interface ICollegeService {

	public CommonResponse create(CollegeDTO college);

	CommonResponse update(UUID id, CollegeDTO collegeDTO);

	CommonResponse getById(UUID id);

	CommonResponse getAll();

	CommonResponse delete(UUID id);


	

}
