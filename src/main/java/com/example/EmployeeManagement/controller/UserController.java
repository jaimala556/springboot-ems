package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.model.User;
import com.example.EmployeeManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/email")
    public void addUser(){

    }
}
