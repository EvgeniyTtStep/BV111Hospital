package com.example.bv111hospital.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
