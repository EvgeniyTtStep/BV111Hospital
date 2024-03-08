package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<VerificationToken, Integer> {
    VerificationToken findByToken(String token);
}
