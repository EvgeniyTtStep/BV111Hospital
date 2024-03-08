package com.example.bv111hospital.service;


import com.example.bv111hospital.entity.ERole;
import com.example.bv111hospital.entity.User;
import com.example.bv111hospital.entity.VerificationToken;
import com.example.bv111hospital.repository.RoleRepo;
import com.example.bv111hospital.repository.TokenRepo;
import com.example.bv111hospital.repository.UserRepo;
import com.example.bv111hospital.security.requests.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    private RoleRepo roleRepo;

    private TokenRepo tokenRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setTokenRepo(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));
    }

    public User createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        roleRepo.findRoleByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        userRepo.save(user);
        return user;
    }

    public User updateUser(User user, String password) {
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepo.save(user);
        return user;
    }



    User getCurrentUser(Principal principal) {
        String username = principal.getName();
        return userRepo.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));
    }

    public void createVerificationToken(User user, String token) {
        VerificationToken newToken = new VerificationToken(token, (long) user.getId());
        tokenRepo.save(newToken);
    }

    public VerificationToken getVerificationToken(String token) {
        return tokenRepo.findByToken(token);
    }

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email).orElse(null);
    }

    public User getUser(String verificationToken) {
        User user = userRepo.findById(Integer.parseInt(tokenRepo.findByToken(verificationToken).getUserId().toString())).get();
        return user;
    }

    public Optional<User> findUserById(Integer id) {
        return userRepo.findUserById(id);
    }

//    public void saveUser(User usertoUpdate) {
//        userRepo.save(usertoUpdate);
//    }
}