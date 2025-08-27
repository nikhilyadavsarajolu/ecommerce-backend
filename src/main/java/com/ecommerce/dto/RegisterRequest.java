package com.ecommerce.dto;

import com.ecommerce.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role = Role.USER; // default USER


}
