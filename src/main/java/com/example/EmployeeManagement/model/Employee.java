package com.example.EmployeeManagement.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "employees")
public class Employee {
    @Id
    private ObjectId id;
    private String firstName;


    private String email;
    private String lastName;
    private String department;
    private List<ObjectId> projectId = new ArrayList<>();
    private List<ObjectId> salaryId = new ArrayList<>();
    private Double baseSalary;
    private boolean isActive;
    private LocalDate joinDate;
    private String hireBy;
    private LocalDateTime LastUpdate;

}
