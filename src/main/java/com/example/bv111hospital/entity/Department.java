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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (idDepartment != null ? !idDepartment.equals(that.idDepartment) : that.idDepartment != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (financing != null ? !financing.equals(that.financing) : that.financing != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepartment != null ? idDepartment.hashCode() : 0;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (financing != null ? financing.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
