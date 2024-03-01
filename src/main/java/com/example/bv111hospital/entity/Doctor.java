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
@EqualsAndHashCode
@Table(name = "doctors")
public class Doctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_doctors", nullable = false)
    private Integer idDoctors;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;
    @Basic
    @Column(name = "premium", nullable = false)
    private Integer premium;
    @Basic
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    @Basic
    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToMany(mappedBy = "doctor")
    private List<Doctorsexamination> doctorsexamination;

    @ManyToMany
    @JoinTable(
            name = "doctorsspecializations",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private Set<Specialization> specializations;


    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Vacation> vacations;

}
