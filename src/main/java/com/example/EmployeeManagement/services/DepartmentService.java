package com.example.EmployeeManagement.services;

import com.example.EmployeeManagement.Helpers.DepartmentHelper;
import com.example.EmployeeManagement.Helpers.DepartmentHelper;
import com.example.EmployeeManagement.model.Department;
import com.example.EmployeeManagement.repository.DepartmentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public String addDepartment(DepartmentHelper departmenthelper) {
        Department department = new Department();
        department.setDepartment(departmenthelper.getDepartment());
        department.setDescription(departmenthelper.getDescription());
        department.setActive(departmenthelper.isActive());
        department.setLastUpdate(LocalDateTime.now());
        department.setMaxEmp(departmenthelper.getMaxEmp());
        departmentRepo.save(department);
        return "Department Saved";


    }

    public String updateDepartment(ObjectId id, Department department) {
        Department oldDepartment = departmentRepo.findById(id).orElse(new Department());
        if (oldDepartment.getId() == null) return "department not found";

        if (department.getDescription() != null && !department.getDescription().equals(oldDepartment.getDescription())) {
            oldDepartment.setDescription(department.getDescription());
        }
        if (department.getDepartment() != null && !department.getDepartment().equals(oldDepartment.getDepartment())) {
            oldDepartment.setDepartment(department.getDepartment());
        }
        if (department.getMaxEmp() != null && !department.getMaxEmp().equals(oldDepartment.getMaxEmp())) {
            oldDepartment.setMaxEmp(department.getMaxEmp());
        }
        if (department.isActive() != oldDepartment.isActive())
            oldDepartment.setActive(department.isActive());
        departmentRepo.save(oldDepartment);
        return "dertm updated";

    }

    public String deleteDepartment(ObjectId id) {
        Optional<Department> department = departmentRepo.findById(id);
        if (department.isEmpty()) {
            return "Department not found.....";
        }
        departmentRepo.deleteById(id);
        return "Department deleted......";

    }

    public Optional<Department> getDepartment(ObjectId id) {
        return departmentRepo.findById(id);

    }

    public List<Department> getDepartments() {

        return departmentRepo.findAll();

    }
}
