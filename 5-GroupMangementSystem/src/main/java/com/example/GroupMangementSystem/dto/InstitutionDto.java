package com.example.GroupMangementSystem.dto;

import java.util.Set;

import com.example.GroupMangementSystem.Entity.BaseEntity;

public class InstitutionDto extends BaseEntity {
	

	
    private Set<CollegeDTO> colleges;

	public Set<CollegeDTO> getColleges() {
		return colleges;
	}

	public void setColleges(Set<CollegeDTO> colleges) {
		this.colleges = colleges;
	}


}
