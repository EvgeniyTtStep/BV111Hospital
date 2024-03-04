package com.example.bv111hospital.security.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {
    @NotEmpty(message = "User can nt be empty")
    private String username;
    @NotEmpty(message = "User can nt be empty")
    private String password;
}
