package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Donations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Amount", nullable = false, precision = 2)
    private BigDecimal amount;
    @Basic
    @Column(name = "Date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "DepartmentId", nullable = false)
    private Integer departmentId;
    @Basic
    @Column(name = "SponsorId", nullable = false)
    private Integer sponsorId;

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "id_department", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "SponsorId", referencedColumnName = "Id", nullable = false)
    private Sponsors sponsorsBySponsorId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donations donations = (Donations) o;

        if (id != null ? !id.equals(donations.id) : donations.id != null) return false;
        if (amount != null ? !amount.equals(donations.amount) : donations.amount != null) return false;
        if (date != null ? !date.equals(donations.date) : donations.date != null) return false;
        if (departmentId != null ? !departmentId.equals(donations.departmentId) : donations.departmentId != null)
            return false;
        if (sponsorId != null ? !sponsorId.equals(donations.sponsorId) : donations.sponsorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (sponsorId != null ? sponsorId.hashCode() : 0);
        return result;
    }

}
