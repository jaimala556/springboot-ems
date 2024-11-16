package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Department;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, ObjectId> {
}
