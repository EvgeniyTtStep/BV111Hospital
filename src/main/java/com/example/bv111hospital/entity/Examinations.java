package com.example.bv111hospital.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;

@Entity
public class Examinations {
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
    @Column(name = "salary", nullable = false, precision = 2)
    private BigDecimal salary;
    @Basic
    @Column(name = "startTime", nullable = false)
    private Time startTime;
    @Basic
    @Column(name = "endTime", nullable = false)
    private Time endTime;
    @OneToMany(mappedBy = "examinationsByExaminationId")
    private Collection<Doctorsexaminations> doctorsexaminationsByIdExaminations;

    public Integer getIdExaminations() {
        return idExaminations;
    }

    public void setIdExaminations(Integer idExaminations) {
        this.idExaminations = idExaminations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Examinations that = (Examinations) o;

        if (idExaminations != null ? !idExaminations.equals(that.idExaminations) : that.idExaminations != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dayOfWeek != null ? !dayOfWeek.equals(that.dayOfWeek) : that.dayOfWeek != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExaminations != null ? idExaminations.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dayOfWeek != null ? dayOfWeek.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    public Collection<Doctorsexaminations> getDoctorsexaminationsByIdExaminations() {
        return doctorsexaminationsByIdExaminations;
    }

    public void setDoctorsexaminationsByIdExaminations(Collection<Doctorsexaminations> doctorsexaminationsByIdExaminations) {
        this.doctorsexaminationsByIdExaminations = doctorsexaminationsByIdExaminations;
    }
}
