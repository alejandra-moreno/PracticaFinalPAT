package com.example.demo.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    String userId;
    String usersName;
    String usersPassword;
    String userEmail;
    String userAge;
}
