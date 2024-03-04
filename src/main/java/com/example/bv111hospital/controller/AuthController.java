package com.example.bv111hospital.controller;

import com.example.bv111hospital.entity.User;
import com.example.bv111hospital.security.JWTTokenProvider;
import com.example.bv111hospital.security.requests.LoginRequest;
import com.example.bv111hospital.security.requests.SignupRequest;
import com.example.bv111hospital.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.HttpResource;


@Controller
public class AuthController {

    private UserService userService;

//    private JWTTokenProvider jwtTokenProvider;
//
//    private AuthenticationManager authenticationManager;
//
//
//    @Autowired
//    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Autowired
//    public void setJwtTokenProvider(JWTTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/login")
//    public String login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
//
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//                loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authenticate);
//
//        String jwt = "Bearer " + jwtTokenProvider.generateToken(authenticate);
//
//        response.setHeader(HttpHeaders.AUTHORIZATION, jwt);
//
//        return "login";
//    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new SignupRequest());
        return "registration";
    }

//    @PostMapping("/register")
//    public String register(@RequestParam(name = "name") String name,
//                           @RequestParam(name = "username")String username,
//                           @RequestParam(name = "email")String email,
//                           @RequestParam(name = "password")String password) {
//        SignupRequest signupRequest = new SignupRequest(name, username, email, password);
//        System.out.println("signupRequest.getName = " + signupRequest.getName());
//        System.out.println("signupRequest.getEmail = " + signupRequest.getEmail());
//        System.out.println("signupRequest.getPassword = " + signupRequest.getPassword());
//        userService.createUser(signupRequest);
//        return "redirect:/doctors";
//    }

    @PostMapping("/register")
    public String register(@ModelAttribute SignupRequest signupRequest) {
        userService.createUser(signupRequest);
        return "redirect:/doctors";
    }


}
