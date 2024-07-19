package com.example.ThymeleafExample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ThymeleafExample.model.Employee;
import com.example.ThymeleafExample.repository.EmployeeRepository;
import com.example.ThymeleafExample.service.IEmployeeService;

@Service
public class ServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository dao;

    @Override
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = dao.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return dao.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = dao.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setEmail(employee.getEmail());
            return dao.save(existingEmployee);
        }
        return null; // Or throw an exception if the employee is not found
    }

    @Override
    public void deleteEmployee(Long id) {
        dao.deleteById(id);
    }
}
