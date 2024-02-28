package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.Doctor;
import com.example.bv111hospital.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepo extends JpaRepository<Specialization, Integer> {

    Specialization getSpecializationByName(String name);

   // List<Doctor> getDoctorsBySpecializations(List<Specialization>specializations);
}
