package com.example.EmployeeManagement.Helpers;

import lombok.*;

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
    private List<String> employees;

}
