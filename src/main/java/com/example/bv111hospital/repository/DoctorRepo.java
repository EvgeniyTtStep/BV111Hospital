package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.Doctor;

import com.example.bv111hospital.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
