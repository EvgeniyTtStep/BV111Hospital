package com.example.bv111hospital.service;

import com.example.bv111hospital.entity.Doctor;
import com.example.bv111hospital.entity.Specialization;
import com.example.bv111hospital.repository.SpecializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecializationService {


    private SpecializationRepo specializationRepo;

    @Autowired
    public void setSpecializationRepo(SpecializationRepo specializationRepo) {
        this.specializationRepo = specializationRepo;
    }


    public List<Specialization> getAll() {
        return specializationRepo.findAll();
    }

    public Specialization getSpecializationByName(String specializationName) {
        return specializationRepo.getSpecializationByName(specializationName);
    }

}
