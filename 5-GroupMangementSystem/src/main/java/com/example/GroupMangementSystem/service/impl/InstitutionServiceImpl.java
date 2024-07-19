package com.example.GroupMangementSystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Institution;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.InstitutionDto;
import com.example.GroupMangementSystem.repository.ICollegeRepository;
import com.example.GroupMangementSystem.repository.IinstitutionRepository;
import com.example.GroupMangementSystem.service.IInstitutionService;

import jakarta.transaction.Transactional;

@Service
public class InstitutionServiceImpl implements IInstitutionService {

    @Autowired
    private IinstitutionRepository institutionRepository;

    @Autowired
    private ICollegeRepository collegeRepository;

    @Override
    public CommonResponse create(InstitutionDto dto) {
        Institution institution = new Institution();
        BeanUtils.copyProperties(dto, institution);
        institutionRepository.save(institution);
        dto.setId(institution.getId());
        return new CommonResponse("success", "201", dto);
    }

    @Override
    public CommonResponse update(UUID id, InstitutionDto dto) {
        Optional<Institution> optionalInstitution = institutionRepository.findById(id);
        if (!optionalInstitution.isPresent()) {
            return new CommonResponse("failure", "404", "Institution not found");
        }

        Institution institution = optionalInstitution.get();
        BeanUtils.copyProperties(dto, institution);
        institution.setId(id);
        institutionRepository.save(institution);
        return new CommonResponse("success", "200", dto);
    }

    @Override
    public CommonResponse getById(UUID id) {
        Optional<Institution> optionalInstitution = institutionRepository.findById(id);
        if (!optionalInstitution.isPresent()) {
            return new CommonResponse("failure", "404", "Institution not found");
        }

        Institution institution = optionalInstitution.get();
        InstitutionDto dto = new InstitutionDto();
        BeanUtils.copyProperties(institution, dto);
        return new CommonResponse("success", "200", dto);
    }

    @Override
    public CommonResponse getAll() {
        List<Institution> institutions = institutionRepository.findAll();
        List<InstitutionDto> dtos = institutions.stream().map(institution -> {
            InstitutionDto dto = new InstitutionDto();
            BeanUtils.copyProperties(institution, dto);
            return dto;
        }).collect(Collectors.toList());
        return new CommonResponse("success", "200", dtos);
    }

    @Override
    public CommonResponse delete(UUID id) {
        if (!institutionRepository.existsById(id)) {
            return new CommonResponse("failure", "404", "Institution not found");
        }

        institutionRepository.deleteById(id);
        return new CommonResponse("success", "200", "Institution deleted successfully");
    }

    @Override
    public CommonResponse addCollegeToInstitution(UUID institutionId, College college) {
        Optional<Institution> institutionOptional = institutionRepository.findById(institutionId);
        if (!institutionOptional.isPresent()) {
            return new CommonResponse("failure", "404", "Institution not found");
        }

        Institution institution = institutionOptional.get();
        college.setInstitution(institution);
        collegeRepository.save(college);

        return new CommonResponse("success", "201", "College added successfully");
    }

    @Override
    public CommonResponse removeCollegeFromInstitution(UUID institutionId, UUID collegeId) {
        Optional<Institution> institutionOptional = institutionRepository.findById(institutionId);
        if (!institutionOptional.isPresent()) {
            return new CommonResponse("failure", "404", "Institution not found");
        }

        Optional<College> collegeOptional = collegeRepository.findById(collegeId);
        if (!collegeOptional.isPresent() || !collegeOptional.get().getInstitution().getId().equals(institutionId)) {
            return new CommonResponse("failure", "404", "College not found or does not belong to the institution");
        }

        College college = collegeOptional.get();
        college.setInstitution(null);
        collegeRepository.save(college);

        return new CommonResponse("success", "200", "College removed from institution successfully");
    }

    @Override
    public CommonResponse getCollegesByInstitutionId(UUID institutionId) {
        Optional<Institution> institutionOptional = institutionRepository.findById(institutionId);
        if (!institutionOptional.isPresent()) {
            return new CommonResponse("failure", "404", "Institution not found");
        }

        Institution institution = institutionOptional.get();
        List<College> colleges = institution.getColleges();
        return new CommonResponse("success", "200", colleges);
    }

	@Override
	@Transactional
	public CommonResponse<List<College>> addCollegesToInstitution(UUID institutionId, List<College> colleges) {
		// TODO Auto-generated method stub
		  Optional<Institution> institutionOptional = institutionRepository.findById(institutionId);
	        if (!institutionOptional.isPresent()) {
	            return new CommonResponse("failure", "404", "Institution not found");
	        }

	        Institution institution = institutionOptional.get();
	        for (College college : colleges) {
	            college.setInstitution(institution);
	            collegeRepository.save(college);
	        }

	        return new CommonResponse("success", "201", "Colleges added successfully");
	    	}
}
