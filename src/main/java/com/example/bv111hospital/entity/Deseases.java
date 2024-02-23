package com.example.bv111hospital;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Deseases {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_deseases", nullable = false)
    private Integer idDeseases;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "severity", nullable = false)
    private Integer severity;
    @OneToMany(mappedBy = "deseasesByDeseasesId")
    private Collection<Doctorsexaminations> doctorsexaminationsByIdDeseases;

    public Integer getIdDeseases() {
        return idDeseases;
    }

    public void setIdDeseases(Integer idDeseases) {
        this.idDeseases = idDeseases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deseases deseases = (Deseases) o;

        if (idDeseases != null ? !idDeseases.equals(deseases.idDeseases) : deseases.idDeseases != null) return false;
        if (name != null ? !name.equals(deseases.name) : deseases.name != null) return false;
        if (severity != null ? !severity.equals(deseases.severity) : deseases.severity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDeseases != null ? idDeseases.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (severity != null ? severity.hashCode() : 0);
        return result;
    }

    public Collection<Doctorsexaminations> getDoctorsexaminationsByIdDeseases() {
        return doctorsexaminationsByIdDeseases;
    }

    public void setDoctorsexaminationsByIdDeseases(Collection<Doctorsexaminations> doctorsexaminationsByIdDeseases) {
        this.doctorsexaminationsByIdDeseases = doctorsexaminationsByIdDeseases;
    }
}
