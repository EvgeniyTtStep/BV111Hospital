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
@Table(name = "wards")
public class Ward {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_wards", nullable = false)
    private Integer idWards;
    @Basic
    @Column(name = "building", nullable = false)
    private Integer building;
    @Basic
    @Column(name = "floor", nullable = false)
    private Integer floor;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "place", nullable = false)
    private Integer place;


    @OneToMany(mappedBy = "ward")
    private List<Doctorsexamination> doctorsexamination;

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "id_department", nullable = false)
    private Department department;


}
