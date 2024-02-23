package com.example.bv111hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Basic
    @Column(name = "DepartmentId", nullable = false)
    private Integer departmentId;

    @OneToMany(mappedBy = "wardsByWardId")
    private Collection<Doctorsexaminations> doctorsexaminationsByIdWards;

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "id_department", nullable = false)
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ward ward = (Ward) o;

        if (idWards != null ? !idWards.equals(ward.idWards) : ward.idWards != null) return false;
        if (building != null ? !building.equals(ward.building) : ward.building != null) return false;
        if (floor != null ? !floor.equals(ward.floor) : ward.floor != null) return false;
        if (name != null ? !name.equals(ward.name) : ward.name != null) return false;
        if (place != null ? !place.equals(ward.place) : ward.place != null) return false;
        if (departmentId != null ? !departmentId.equals(ward.departmentId) : ward.departmentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWards != null ? idWards.hashCode() : 0;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        return result;
    }

}
