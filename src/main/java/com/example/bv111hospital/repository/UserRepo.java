package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

}
