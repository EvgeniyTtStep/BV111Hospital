package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "deseases")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deseases", nullable = false)
    private Integer idDeseases;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "severity", nullable = false)
    private Integer severity;

    @OneToMany(mappedBy = "disease")
    private List<Doctorsexamination> doctorsexamination;




}
