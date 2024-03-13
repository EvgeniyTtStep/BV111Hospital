package com.example.bv111hospital.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DoctorDTO {
    private Integer idDoctors;
    private String name;
    private String phone;
    private Integer premium;
    private BigDecimal salary;
    private String surname;
}
