package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.Helpers.DepartmentHelper;
import com.example.EmployeeManagement.Helpers.DepartmentHelper;
import com.example.EmployeeManagement.model.Department;
import com.example.EmployeeManagement.services.DepartmentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/department")
    public String addDepartment(@RequestBody DepartmentHelper departmentHelper) {
        return departmentService.addDepartment(departmentHelper);
    }

    @GetMapping("/department/{id}")
    public Optional<Department> getDepartment(@PathVariable ObjectId id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable ObjectId id) {
        return departmentService.deleteDepartment(id);
    }

    @PutMapping("/department/{id}")
    public String updateDepartment(@PathVariable ObjectId id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }
}
