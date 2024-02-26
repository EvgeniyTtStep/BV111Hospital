package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "doctorsexaminations")
public class Doctorsexamination {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_doctorsexaminations", nullable = false)
    private Integer idDoctorsexaminations;
    @Basic
    @Column(name = "EndTime", nullable = false)
    private Time endTime;
    @Basic
    @Column(name = "StartTime", nullable = false)
    private Time startTime;




    @ManyToOne
    @JoinColumn(name = "deseases_id", referencedColumnName = "id_deseases", nullable = false)
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id_doctors", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "examination_id", referencedColumnName = "id_examinations", nullable = false)
    private Examination examination;

    @ManyToOne
    @JoinColumn(name = "ward_id", referencedColumnName = "id_wards", nullable = false)
    private Ward ward;


}
