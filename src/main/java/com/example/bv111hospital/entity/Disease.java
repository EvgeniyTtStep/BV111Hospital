package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        if (idDeseases != null ? !idDeseases.equals(disease.idDeseases) : disease.idDeseases != null) return false;
        if (name != null ? !name.equals(disease.name) : disease.name != null) return false;
        if (severity != null ? !severity.equals(disease.severity) : disease.severity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDeseases != null ? idDeseases.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (severity != null ? severity.hashCode() : 0);
        return result;
    }


}
