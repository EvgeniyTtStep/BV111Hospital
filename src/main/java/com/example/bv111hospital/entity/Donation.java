package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "donations")
public class Donation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;
    @Basic
    @Column(name = "Date", nullable = false)
    private Date date;


    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "id_department", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "SponsorId", referencedColumnName = "Id", nullable = false)
    private Sponsor sponsor;


}
