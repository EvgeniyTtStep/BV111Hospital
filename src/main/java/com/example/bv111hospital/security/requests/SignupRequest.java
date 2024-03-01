package com.example.bv111hospital.security.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignupRequest {

    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotEmpty(message = "Username can not be empty")
    private String username;
    @NotEmpty(message = "Email can not be empty")
    private String email;
    @NotEmpty(message = "Password can not be empty")
    private String password;

}
