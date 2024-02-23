package com.example.bv111hospital.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Sponsors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @OneToMany(mappedBy = "sponsorsBySponsorId")
    private Collection<Donations> donationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sponsors sponsors = (Sponsors) o;

        if (id != null ? !id.equals(sponsors.id) : sponsors.id != null) return false;
        if (name != null ? !name.equals(sponsors.name) : sponsors.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Donations> getDonationsById() {
        return donationsById;
    }

    public void setDonationsById(Collection<Donations> donationsById) {
        this.donationsById = donationsById;
    }
}
