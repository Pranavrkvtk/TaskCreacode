package com.example.ThymeleafExample.service;

import java.util.List;

import com.example.ThymeleafExample.model.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
