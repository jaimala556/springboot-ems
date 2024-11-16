package com.example.EmployeeManagement.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Departments")
public class Department {
    @Id
    private ObjectId id;
    private String department;
    private String description;
    private Integer maxEmp;
    private boolean isActive=true;
    private LocalDateTime lastUpdate;
}
