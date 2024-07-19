package com.example.ThymeleafExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ThymeleafExample.model.Employee;
import com.example.ThymeleafExample.service.IEmployeeService;

@Controller // Use @Controller instead of @RestController for handling views
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list"; // Assuming there's a Thymeleaf template named employee-list.html
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-detail"; // Assuming there's a Thymeleaf template named employee-detail.html
        } else {
            return "error/404"; // Assuming there's a Thymeleaf template named 404.html for not found
        }
    }

    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form"; // Assuming there's a Thymeleaf template named employee-form.html
    }

    @PostMapping
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-form"; // Reusing the employee-form.html for editing
        } else {
            return "error/404"; // Assuming there's a Thymeleaf template named 404.html for not found
        }
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
