package com.example.EmployeeManagement.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "salary")
public class Salary {
    @Id
    private ObjectId id;
    private Double baseSalary;
    private Double bonus;
    private byte totalWorkingDays;
    private byte workingDays;
    private byte leave;
    private byte overtime;
    private String monthYear;
    private Double totalSalary;
    private boolean isPaid;
    private ObjectId empId;


}
