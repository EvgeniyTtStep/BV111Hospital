package com.example.bv111hospital.controller;

import com.example.bv111hospital.entity.Doctor;
import com.example.bv111hospital.entity.Specialization;
import com.example.bv111hospital.service.DoctorService;
import com.example.bv111hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorsController {


    private DoctorService doctorService;

    private SpecializationService specializationService;

    @Autowired
    public void setSpecializationService(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("specializations", specializationService.getAll());
        return "doctors";
    }


    @GetMapping("/doctor/specializations")
    public String carCategory(@RequestParam(value = "selectedSpecializations", required = false) List<String> selectedSpecializations,
                              Model model) {
        List<Specialization> specializations = new ArrayList<>();


        if (selectedSpecializations == null || selectedSpecializations.isEmpty()) {
            return "redirect:/doctors";
        } else {

            for (String specialization : selectedSpecializations) {
                System.out.println(specialization);
                specializations.add(specializationService.getSpecializationByName(specialization));
            }
        }

        List<Doctor> doctors = doctorService.getDoctorsBySpecializations(specializations);
        for (Doctor doctor : doctors) {
            System.out.println("doctor = " + doctor);
        }

        model.addAttribute("specializations", specializationService.getAll());
        model.addAttribute("doctors", doctors);

        return "doctors";
    }
}
