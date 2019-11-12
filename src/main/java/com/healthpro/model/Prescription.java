package com.healthpro.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "prescription")
public class Prescription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long presc_id;

    public Prescription(Long physician, Long patient, Long medication, String dose, String dosage) {
        this.physician = physician;
        this.patient = patient;
        this.medication = medication;
        this.dose = dose;
        this.dosage = dosage;
    }

    @Column(name="physician")
    public Long physician;

    @Column(name="patient")
    public Long patient;

    @Column(name="medication")
    public Long medication;

    @Column(name="dose")
    public String dose;

    @Column(name="dosage")
    public String dosage;

    public Prescription() {
    }

    public Long getPresc_id() {
        return presc_id;
    }

    public void setPresc_id(Long presc_id) {
        this.presc_id = presc_id;
    }

    public Long getPhysician() {
        return physician;
    }

    public void setPhysician(Long physician) {
        this.physician = physician;
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public Long getMedication() {
        return medication;
    }

    public void setMedication(Long medication) {
        this.medication = medication;
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
        Prescription that = (Prescription) o;
        return Objects.equals(presc_id, that.presc_id) &&
                Objects.equals(physician, that.physician) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(medication, that.medication) &&
                Objects.equals(dose, that.dose) &&
                Objects.equals(dosage, that.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(presc_id, physician, patient, medication, dose, dosage);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "presc_id=" + presc_id +
                ", physician=" + physician +
                ", patient=" + patient +
                ", medication=" + medication +
                ", dose='" + dose + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}
