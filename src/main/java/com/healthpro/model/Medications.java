package com.healthpro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medications")
public class Medications {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long drug_id;

@Column(name="drug_name")
        private String drug_name;

    @Column(name="drug_type")
        private String drug_type;

    @Column(name="dose")
    private String dose;

    @Column(name="dosage")
        private String dosage;


//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "medications")
//    private Set<Medications> medications = new HashSet<>();


    public Medications() {
    }

    public Medications(String drug_name, String drug_type, String dose, String dosage) {
        this.drug_name = drug_name;
        this.drug_type = drug_type;
        this.dose = dose;
        this.dosage = dosage;
    }

    public Long getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Long drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
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
        Medications that = (Medications) o;
        return Objects.equals(drug_id, that.drug_id) &&
                Objects.equals(drug_name, that.drug_name) &&
                Objects.equals(drug_type, that.drug_type) &&
                Objects.equals(dose, that.dose) &&
                Objects.equals(dosage, that.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drug_id, drug_name, drug_type, dose, dosage);
    }

    @Override
    public String toString() {
        return "Medications{" +
                "drug_id='" + drug_id + '\'' +
                ", drug_name='" + drug_name + '\'' +
                ", drug_type='" + drug_type + '\'' +
                ", dose='" + dose + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}





