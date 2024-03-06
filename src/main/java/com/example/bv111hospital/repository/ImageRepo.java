package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepo extends JpaRepository<Image, Integer> {

    Image findByDoctorId(Long doctorId);
}
