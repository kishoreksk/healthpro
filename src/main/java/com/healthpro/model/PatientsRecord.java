package com.healthpro.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "bloodgroup")
    private String bloodgroup;

    @Column(name = "med_id")
    private int med_id;

    @Column(name = "drug_type")
    private String drug_type;

    @Column(name = "dose")
    private String dose;

    @Column(name = "dosage")
    private String dosage;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "patient_medications",
//            joinColumns = { @JoinColumn(name = "patient_id") },
//            inverseJoinColumns = { @JoinColumn(name = "medications_id") })
//    private Set<PatientsRecord> patientsRecords = new HashSet<>();





    public PatientsRecord() {
    }


    public PatientsRecord(String name, String gender, String age, String address, String disease, String admission, String discharge, String bloodgroup, int med_id, String drug_type, String dose, String dosage) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.disease = disease;
        this.admission = admission;
        this.discharge = discharge;
        this.bloodgroup = bloodgroup;
        this.med_id = med_id;
        this.drug_type = drug_type;
        this.dose = dose;
        this.dosage = dosage;
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

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public int getDrug_name() {
        return med_id;
    }

    public void setDrug_name(int drug_name) {
        this.med_id = drug_name;
    }

    public String getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(String drug_type) {
        this.drug_type = drug_type;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
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
                Objects.equals(discharge, that.discharge) &&
                Objects.equals(bloodgroup, that.bloodgroup) &&
                Objects.equals(med_id, that.med_id) &&
                Objects.equals(drug_type, that.drug_type) &&
                Objects.equals(dose, that.dose) &&
                Objects.equals(dosage, that.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age, address, disease, admission, discharge, bloodgroup, med_id, drug_type, dose, dosage);
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
                ", bloodgroup='" + bloodgroup + '\'' +
                ", drug_name='" + med_id + '\'' +
                ", drug_type='" + drug_type + '\'' +
                ", dose='" + dose + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}

