package com.example.EmployeeManagement.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "projects")
public class Project {
    @Id
    private ObjectId id;
    private String projectName;
    private String description;
    private String techStack;
    private String clientName;
    private Integer budget;
    private List<String> employees;
    private boolean isActive;
    private LocalDateTime lastUpdate;
}
