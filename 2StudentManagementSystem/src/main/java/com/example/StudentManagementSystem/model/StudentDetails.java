package com.example.StudentManagementSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentdetails")
public class StudentDetails extends BaseEntity {

	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "adm_no")
	private String admNo;
	@Column(name = "roll_no")
	private int RollNo;
	private String address;
	private String gender;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name="age")
	private int age;
	private double height;
	private double weight;
	private String dob;
	private String phone;
	
	@Column(name="father_designation")
	private String fatherDesgnation;
	
	@Column(name="mother_designation")
	private String motherDesignation;

	public String getAdmNo() {
		return admNo;
	}

	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}

	public int getRollNo() {
		return RollNo;
	}

	public void setRollNo(int rollNo) {
		RollNo = rollNo;
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
	
	
	
	

	
}