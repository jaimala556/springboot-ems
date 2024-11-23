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
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private String firstname;
    private boolean isLoggedIn;
    private int otp;
    private String isActive;
    private LocalDateTime lastUpdate;
}
