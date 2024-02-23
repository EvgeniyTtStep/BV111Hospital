package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctors {
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

    @OneToMany(mappedBy = "doctorsByDoctorId")
    private Collection<Doctorsexaminations> doctorsexaminationsByIdDoctors;

    @ManyToMany
    @JoinTable(
            name = "doctorsspecializations",
            joinColumns = @JoinColumn(name = "DoctorId"),
            inverseJoinColumns = @JoinColumn(name = "SpecializationId"))
    private Set<Specializations> specializations;


    @OneToMany(mappedBy = "doctorsByDoctorId")
    private Collection<Vacations> vacationsByIdDoctors;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctors doctors = (Doctors) o;

        if (idDoctors != null ? !idDoctors.equals(doctors.idDoctors) : doctors.idDoctors != null) return false;
        if (name != null ? !name.equals(doctors.name) : doctors.name != null) return false;
        if (phone != null ? !phone.equals(doctors.phone) : doctors.phone != null) return false;
        if (premium != null ? !premium.equals(doctors.premium) : doctors.premium != null) return false;
        if (salary != null ? !salary.equals(doctors.salary) : doctors.salary != null) return false;
        if (surname != null ? !surname.equals(doctors.surname) : doctors.surname != null) return false;

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
