package com.example.bv111hospital.controller.rest;

import com.example.bv111hospital.entity.User;
import com.example.bv111hospital.security.JWTTokenProvider;
import com.example.bv111hospital.security.requests.LoginRequest;
import com.example.bv111hospital.security.requests.SignupRequest;
import com.example.bv111hospital.security.responce.JwtTokenSuccessResponse;
import com.example.bv111hospital.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthRestController {

    private JWTTokenProvider jwtTokenProvider;

    private AuthenticationManager authenticationManager;

    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtTokenProvider(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = "Bearer " + jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtTokenSuccessResponse(true, jwt));
    }


    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody SignupRequest signupRequest) {
        userService.createUser(signupRequest);
        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7); // Remove the "Bearer " prefix
            response.setHeader("Authorization", jwtToken);
            return ResponseEntity.ok("Logout successful");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Authorization header");
    }


}
