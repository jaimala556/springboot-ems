package com.example.EmployeeManagement.Helpers;

import lombok.*;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryHelper {

    private Double baseSalary;
    private Double bonus;
    private byte totalWorkingDays;
    private byte workingDays;
    private byte leave;
    private byte overtime;
    private String monthYear;
    private ObjectId empId;


}
