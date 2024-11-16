package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends MongoRepository<Project, ObjectId> {
}
