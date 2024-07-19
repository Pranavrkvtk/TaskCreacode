package com.example.GroupMangementSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Institution;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.InstitutionDto;

public interface IInstitutionService {
    public CommonResponse create(InstitutionDto dto);
    public CommonResponse update(UUID id, InstitutionDto dto);
    public CommonResponse getById(UUID id);
    public CommonResponse getAll();
    public CommonResponse delete(UUID id);


    CommonResponse addCollegeToInstitution(UUID institutionId, College college);
    CommonResponse removeCollegeFromInstitution(UUID institutionId, UUID collegeId);
    CommonResponse getCollegesByInstitutionId(UUID institutionId);
    
    CommonResponse<List<College>> addCollegesToInstitution(UUID institutionId, List<College> colleges);

}
