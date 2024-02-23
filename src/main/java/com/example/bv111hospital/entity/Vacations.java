package com.example.bv111hospital.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Vacations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "EndDate", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "StartDate", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "DoctorId", nullable = false)
    private Integer doctorId;
    @ManyToOne
    @JoinColumn(name = "DoctorId", referencedColumnName = "id_doctors", nullable = false)
    private Doctor doctorByDoctorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacations vacations = (Vacations) o;

        if (id != null ? !id.equals(vacations.id) : vacations.id != null) return false;
        if (endDate != null ? !endDate.equals(vacations.endDate) : vacations.endDate != null) return false;
        if (startDate != null ? !startDate.equals(vacations.startDate) : vacations.startDate != null) return false;
        if (doctorId != null ? !doctorId.equals(vacations.doctorId) : vacations.doctorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (doctorId != null ? doctorId.hashCode() : 0);
        return result;
    }

    public Doctor getDoctorsByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorsByDoctorId(Doctor doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }
}
