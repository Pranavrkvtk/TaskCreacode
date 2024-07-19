package com.example.GroupMangementSystem.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GroupMangementSystem.Entity.BaseEntity;
import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Institution;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.CollegeDTO;
import com.example.GroupMangementSystem.dto.InstitutionDto;
import com.example.GroupMangementSystem.repository.ICollegeRepository;
import com.example.GroupMangementSystem.service.ICollegeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	private ICollegeRepository dao;

	@Override
	public CommonResponse create(CollegeDTO collegeDTO) {
		College data = new College();
		BeanUtils.copyProperties(collegeDTO, data);
		dao.save(data);
		collegeDTO.setId(data.getId());

		return new CommonResponse("success", "201", collegeDTO);
	}

	@Override
	public CommonResponse update(UUID id, CollegeDTO collegeDTO) {
		Optional<College> optionalCollege = dao.findById(id);
		if (!optionalCollege.isPresent()) {
			return new CommonResponse("failure", "404", "College not found");
		}

		College college = optionalCollege.get();
		BeanUtils.copyProperties(collegeDTO, college);
		college.setId(id);
		dao.save(college);

		return new CommonResponse("success", "200", collegeDTO);
	}

	@Override
	public CommonResponse getById(UUID id) {
		Optional<College> optionalCollege = dao.findById(id);
		if (!optionalCollege.isPresent()) {
			return new CommonResponse("failure", "404", "College not found");
		}

		College college = optionalCollege.get();
		CollegeDTO collegeDTO = new CollegeDTO();
		BeanUtils.copyProperties(college, collegeDTO);
		return new CommonResponse("success", "200", collegeDTO);
	}

	@Override
	public CommonResponse getAll() {
		List<College> colleges = dao.findAll();
		List<CollegeDTO> collegeDTOs = colleges.stream().map(college -> {
			CollegeDTO collegeDTO = new CollegeDTO();
			BeanUtils.copyProperties(college, collegeDTO);
			return collegeDTO;
		}).collect(Collectors.toList());

		return new CommonResponse("success", "200", collegeDTOs);
	}

	@Override
	public CommonResponse delete(UUID id) {
		if (!dao.existsById(id)) {
			return new CommonResponse("failure", "404", "College not found");
		}

		dao.deleteById(id);
		return new CommonResponse("success", "200", "College deleted successfully");
	}

}