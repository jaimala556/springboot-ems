package com.example.EmployeeManagement.model;

import com.example.EmployeeManagement.configurations.Deserialization;
import com.example.EmployeeManagement.configurations.Serialization;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @JsonSerialize(using = Serialization.class)
    @JsonDeserialize(using = Deserialization.class)
    private List<ObjectId> employees;

    private boolean isActive;
    private LocalDateTime lastUpdate;
}
