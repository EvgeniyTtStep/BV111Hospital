package com.example.bv111hospital.facade;

import com.example.bv111hospital.dto.DoctorDTO;
import com.example.bv111hospital.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorFacade {
    public DoctorDTO doctotToDoctorDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setIdDoctors(doctor.getIdDoctors());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setPhone(doctor.getPhone());
        doctorDTO.setSalary(doctor.getSalary());
        doctorDTO.setPremium(doctor.getPremium());
        doctorDTO.setSurname(doctor.getSurname());
        return doctorDTO;
    }
}
