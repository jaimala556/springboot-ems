package com.example.EmployeeManagement.services;

import com.example.EmployeeManagement.Helpers.EmployeeHelper;
import com.example.EmployeeManagement.model.Department;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public String addEmployee(EmployeeHelper employeeHelper) {
        Employee employee = new Employee();

        // verify email id
        List<Employee> employeeArrayList = employeeRepo.findAll();

        for (Employee employee1 : employeeArrayList) {
            if (employeeHelper.getEmail().equals(employee1.getEmail())) return "Change email, it is already exists..";
        }


//        verify project id

        employee.setFirstName(employeeHelper.getFirstName());
        employee.setLastName(employeeHelper.getLastName());
        employee.setDepartment(employeeHelper.getDepartment());
        employee.setProjectId(employeeHelper.getProjectId());
        employee.setSalaryId(employeeHelper.getSalaryId());
        employee.setBaseSalary(employeeHelper.getBaseSalary());
        employee.setHireBy(employeeHelper.getHireBy());
        employee.setJoinDate(employeeHelper.getJoinDate());
        employee.setEmail(employeeHelper.getEmail());
        employee.setLastUpdate(LocalDateTime.now());
        employeeRepo.save(employee);
        return "save employee......";
    }

    public String updateEmployee(ObjectId id, Employee employee) {
        Employee oldEmployee = employeeRepo.findById(id).orElse(new Employee());
        if (oldEmployee.getId() == null) return "employee not found";

        if (employee.getFirstName() != null && employee.getFirstName().equals(oldEmployee.getFirstName())) {
            oldEmployee.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null && employee.getLastName().equals(oldEmployee.getLastName())) {
            oldEmployee.setLastName(employee.getLastName());

        }
        if (employee.getEmail() != null && employee.getEmail().equals(oldEmployee.getEmail())) {
            oldEmployee.setEmail(employee.getEmail());

        }
        if (employee.getDepartment() != null && employee.getDepartment().equals(oldEmployee.getDepartment())) {
            oldEmployee.setDepartment(employee.getDepartment());
        }
        if (employee.getProjectId() != null && employee.getProjectId().equals(oldEmployee.getProjectId())) {
            oldEmployee.setProjectId(employee.getProjectId());
        }
        if (employee.getSalaryId() != null && employee.getSalaryId().equals(oldEmployee.getSalaryId())) {
            oldEmployee.setSalaryId(employee.getSalaryId());
        }
        if (employee.getHireBy() != null && employee.getHireBy().equals(oldEmployee.getHireBy())) {
            oldEmployee.setHireBy(employee.getHireBy());
        }
        if (employee.getBaseSalary() != null && employee.getBaseSalary().equals(oldEmployee.getBaseSalary())) {
            oldEmployee.setBaseSalary(employee.getBaseSalary());
        }
        if (employee.getJoinDate() != null && employee.getJoinDate().equals(oldEmployee.getJoinDate())) {
            oldEmployee.setJoinDate(employee.getJoinDate());
        }

        employeeRepo.save(employee);
        return "employee updated....";
    }

    public String deleteEmployee(ObjectId id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isEmpty()) {
            return "Employee not found....";
        }
        employeeRepo.deleteById(id);
        return "Employee deleted";

    }

    public Optional<Employee> getEmployeeById(ObjectId id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();

    }
}
