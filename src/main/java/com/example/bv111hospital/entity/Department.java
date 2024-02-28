package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "departments")
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_department", nullable = false)
    private Integer idDepartment;
    @Basic
    @Column(name = "building", nullable = false)
    private Integer building;
    @Basic
    @Column(name = "floor", nullable = false)
    private Integer floor;
    @Basic
    @Column(name = "financing", nullable = false, precision = 2)
    private BigDecimal financing;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Donation> donations;

    @OneToMany(mappedBy = "department")
    private Set<Ward> wards;





}
