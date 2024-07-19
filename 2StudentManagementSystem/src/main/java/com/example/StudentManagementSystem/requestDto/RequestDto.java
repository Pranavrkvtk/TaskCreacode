package com.example.StudentManagementSystem.requestDto;

import java.util.List;

import com.example.StudentManagementSystem.model.BaseEntity;

public class RequestDto extends BaseEntity {

	private String name;
	private String admNo;
	private int rollNo;
	private String address;
	private String gender;
	private String fatherName;
	private String motherName;
	private int age;
	private double height;
	private double weight;
	private String dob;
	private String phone;
	private String fatherDesgnation;
	private String motherDesignation;

	private List<RequestDto> dtoList;

	public String getAdmNo() {
		return admNo;
	}

	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFatherDesgnation() {
		return fatherDesgnation;
	}

	public void setFatherDesgnation(String fatherDesgnation) {
		this.fatherDesgnation = fatherDesgnation;
	}

	public String getMotherDesignation() {
		return motherDesignation;
	}

	public void setMotherDesignation(String motherDesignation) {
		this.motherDesignation = motherDesignation;
	}

	public List<RequestDto> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<RequestDto> dtoList) {
		this.dtoList = dtoList;
	}

}