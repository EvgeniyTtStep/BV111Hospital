package com.example.bv111hospital.service;

import com.example.bv111hospital.entity.Doctor;
import com.example.bv111hospital.entity.Specialization;
import com.example.bv111hospital.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private DoctorRepo doctorRepo;

    @Autowired
    public void setDoctorRepo(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }

//    public List<Doctor> getDoctorsBySpecializations(List<Specialization> specializations) {
//        return doctorRepo.getDoctorsBySpecializations(specializations);
//    }


    public List<Doctor> getDoctorsBySpecializations(List<Specialization> specializations) {
        List<Doctor> doctorAll = doctorRepo.findAll();
        List<Doctor> filteredDoctors = new ArrayList<>();

        for (Doctor doctor : doctorAll) {
            boolean containsSpec = false;
            for (Specialization specialization : specializations) {
                if (doctor.getSpecializations().contains(specialization)) {
                    containsSpec = true;
                    break;
                }
            }
            if (containsSpec) {
                filteredDoctors.add(doctor);
            }
        }
        return filteredDoctors;
    }

    public Doctor getById(Integer idDoctor) {
        return doctorRepo.findById(idDoctor).orElse(new Doctor());
    }
}
