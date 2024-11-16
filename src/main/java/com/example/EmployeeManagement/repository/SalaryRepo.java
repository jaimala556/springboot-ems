package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Salary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends MongoRepository<Salary, ObjectId> {
}
