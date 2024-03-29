package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserById(Integer id);

    Optional<User> findUserByEmail(String email);

}
