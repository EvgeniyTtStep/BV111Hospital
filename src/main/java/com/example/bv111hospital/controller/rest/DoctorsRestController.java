package com.example.bv111hospital.controller.rest;

import com.example.bv111hospital.dto.DoctorDTO;
import com.example.bv111hospital.entity.Doctor;
import com.example.bv111hospital.entity.Specialization;
import com.example.bv111hospital.facade.DoctorFacade;
import com.example.bv111hospital.service.DoctorService;
import com.example.bv111hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DoctorsRestController {


    private DoctorService doctorService;

    private SpecializationService specializationService;

    private DoctorFacade doctorFacade;


    @Autowired
    public void setDoctorFacade(DoctorFacade doctorFacade) {
        this.doctorFacade = doctorFacade;
    }

    @Autowired
    public void setSpecializationService(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public ResponseEntity<Object> doctors() {
        List<Doctor> doctors = doctorService.getAll();
        List<DoctorDTO> doctorsDTO = new ArrayList<>();

        for (Doctor doctor : doctors) {
            doctorsDTO.add(doctorFacade.doctotToDoctorDTO(doctor));
        }

        List<Specialization> specializations = specializationService.getAll();
        return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
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

    @GetMapping("/doctor/info/{id_doctor}")
    public String info(@PathVariable(value = "id_doctor") Integer idDoctor, Model model) {
        Doctor doctorById = doctorService.getById(idDoctor);
        model.addAttribute("doctor", doctorById);
        return "doctor-info";
    }


}
