package com.example.ThymeleafExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ThymeleafExample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
