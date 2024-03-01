package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.ERole;
import com.example.bv111hospital.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Optional<Role> findRoleByName(ERole name);

}
