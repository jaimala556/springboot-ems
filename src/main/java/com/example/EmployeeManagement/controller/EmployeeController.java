package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.Helpers.EmployeeHelper;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.services.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public String addEmployee(@RequestBody EmployeeHelper employeeHelper) {
        return employeeService.addEmployee(employeeHelper);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable ObjectId id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable ObjectId id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable  ObjectId id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
}


