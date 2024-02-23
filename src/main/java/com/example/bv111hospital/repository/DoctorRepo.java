package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
