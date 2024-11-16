package com.example.EmployeeManagement.Helpers;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentHelper {

    private String department;
    private String description;
    private Integer maxEmp;
    private boolean isActive=true;

}
