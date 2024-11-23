package com.example.EmployeeManagement.Helpers;

import com.example.EmployeeManagement.configurations.Deserialization;
import com.example.EmployeeManagement.configurations.Serialization;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectHelper {

    private String projectName;
    private String description;
    private String techStack;
    private String clientName;
    private Integer budget;

    @JsonSerialize(using = Serialization.class)
    @JsonDeserialize(using = Deserialization.class)
    private List<ObjectId> employees;

}
