package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "examinations")
public class Examination {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_examinations", nullable = false)
    private Integer idExaminations;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "dayOfWeek", nullable = false)
    private Integer dayOfWeek;
    @Basic
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    @Basic
    @Column(name = "startTime", nullable = false)
    private Time startTime;
    @Basic
    @Column(name = "endTime", nullable = false)
    private Time endTime;

    @OneToMany(mappedBy = "examination")
    private List<Doctorsexamination> doctorsexamination;





}
