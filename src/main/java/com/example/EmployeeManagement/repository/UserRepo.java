package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    Optional<User> findByEmail (String email);
}
