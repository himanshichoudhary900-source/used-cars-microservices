package com.usedcars.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;  // Display name
    private String email;
    private String name;      // Full name
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String role;
    private String password;  // Only for registration

    // Simplified constructor
    public UserDto(Long id, String username, String email, String firstName,
                   String lastName, String phone, String address, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }
}