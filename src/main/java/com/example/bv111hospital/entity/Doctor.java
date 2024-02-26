package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_doctors", nullable = false)
    private Integer idDoctors;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Basic
    @Column(name = "premium", nullable = false)
    private Integer premium;
    @Basic
    @Column(name = "salary", nullable = false, precision = 2)
    private BigDecimal salary;
    @Basic
    @Column(name = "surname", nullable = false, length = 255)
    private String surname;

    @OneToMany(mappedBy = "doctor")
    private List<Doctorsexamination> doctorsexamination;

    @ManyToMany
    @JoinTable(
            name = "doctorsspecializations",
            joinColumns = @JoinColumn(name = "DoctorId"),
            inverseJoinColumns = @JoinColumn(name = "SpecializationId"))
    private Set<Specialization> specializations;


    @OneToMany(mappedBy = "doctor")
    private List<Vacation> vacations;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (idDoctors != null ? !idDoctors.equals(doctor.idDoctors) : doctor.idDoctors != null) return false;
        if (name != null ? !name.equals(doctor.name) : doctor.name != null) return false;
        if (phone != null ? !phone.equals(doctor.phone) : doctor.phone != null) return false;
        if (premium != null ? !premium.equals(doctor.premium) : doctor.premium != null) return false;
        if (salary != null ? !salary.equals(doctor.salary) : doctor.salary != null) return false;
        if (surname != null ? !surname.equals(doctor.surname) : doctor.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDoctors != null ? idDoctors.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (premium != null ? premium.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

}
