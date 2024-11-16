package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository <Employee , ObjectId>{

}
