package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "vacations")
public class Vacation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;


    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id_doctors", nullable = false)
    private Doctor doctor;

}
