package com.example.bv111hospital.controller;

import com.example.bv111hospital.email.events.password.OnPasswordResetEvent;
import com.example.bv111hospital.email.events.registration.OnRegistrationCompleteEvent;
import com.example.bv111hospital.entity.User;
import com.example.bv111hospital.entity.VerificationToken;
import com.example.bv111hospital.security.requests.SignupRequest;
import com.example.bv111hospital.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Calendar;
import java.util.Optional;


@Controller
public class AuthController {

    private UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

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
    public String register(@ModelAttribute SignupRequest signupRequest, HttpServletRequest request) {
        User user = userService.createUser(signupRequest);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, request.getLocale(), request.getContextPath()));
        return "redirect:/doctors";
    }

    @GetMapping("/registrationConfirm")
    public String registrationConfirm(@RequestParam(name = "token") String token) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            System.out.println("verificationToken = is NULL");
        }
        System.out.println("verificationToken = " + verificationToken.getToken());
        return "redirect:/login";
    }


    @GetMapping("/password_reset")
    public String passwordReset() {
        return "password-reset";
    }

    @PostMapping("/password_reset")
    public String passwordReset(@RequestParam(name = "email") String email, HttpServletRequest request) {
        System.out.println("=== Enter passwordReset ===");
        User existing = userService.findUserByEmail(email);
        System.out.println("existing.getEmail() = " + existing.getEmail());
        System.out.println("existing.getUsername() = " + existing.getUsername());
        System.out.println("existing.getName() = " + existing.getName());
        eventPublisher.publishEvent(new OnPasswordResetEvent(existing, request.getLocale(), request.getContextPath()));
        return "redirect:/doctors";
    }

    @GetMapping("/password_reset/{id}/passwordResetConfirm")
    public String resetPswdPage(@PathVariable String id, @RequestParam String token, Model model) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        User user = userService.getUser(token);
        System.out.println(user.getUsername());
        model.addAttribute("user", user);
        return "password_reset_form";
    }

    @PostMapping("/password_reset/{id}/passwordResetConfirm")
    public String pswd_reset_apply(@PathVariable(name = "id") Integer id, @RequestParam String password, HttpServletRequest request) {
        Optional<User> existing = userService.findUserById(id);
        User usertoUpdate = existing.get();
        if (password != null) {
            userService.updateUser(usertoUpdate, password);
        }

        return "redirect:/login";
    }


}
