package com.example.EmployeeManagement.Helpers;

import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeHelper {

    private  String firstName;
    private  String lastName;
    private String email;
    private  String department;
    private List<ObjectId> projectId = new ArrayList<>();
    private List<ObjectId> salaryId = new ArrayList<>();
    private  Double baseSalary;
    private LocalDate joinDate;
    private String hireBy;

}
