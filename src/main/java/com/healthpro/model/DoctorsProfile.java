package com.healthpro.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "doctorsprofile")
public class DoctorsProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "speciality", length = 100)
    private String speciality;

    public DoctorsProfile(Long id, String name, String type, String speciality) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.speciality = speciality;
    }

    public DoctorsProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "DoctorsProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorsProfile that = (DoctorsProfile) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(speciality, that.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, speciality);
    }
}
