package com.healthpro.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city", length = 100)
    private String city;


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pharmacy(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Pharmacy(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;

    }

    public Pharmacy() {
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(id, pharmacy.id) &&
                Objects.equals(name, pharmacy.name) &&
                Objects.equals(city, pharmacy.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
