package com.healthpro.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patientsrecord")
public class PatientsRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "address")
    private String address;

    @Column(name = "disease")
    private String disease;

    @Column(name = "admission")
    private String admission;

    @Column(name = "discharge")
    private String discharge;


    public PatientsRecord() {
    }

    public PatientsRecord(Long id, String name, String gender, String age, String address, String disease, String admission, String discharge) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.disease = disease;
        this.admission = admission;
        this.discharge = discharge;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getDischarge() {
        return discharge;
    }

    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }

    @Override
    public String toString() {
        return "PatientsRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", disease='" + disease + '\'' +
                ", admission='" + admission + '\'' +
                ", discharge='" + discharge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientsRecord that = (PatientsRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(age, that.age) &&
                Objects.equals(address, that.address) &&
                Objects.equals(disease, that.disease) &&
                Objects.equals(admission, that.admission) &&
                Objects.equals(discharge, that.discharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age, address, disease, admission, discharge);
    }
}
