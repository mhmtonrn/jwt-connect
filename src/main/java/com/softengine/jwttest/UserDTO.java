package com.softengine.jwttest;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
