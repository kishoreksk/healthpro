package com.healthpro.service;


import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Prescription;
import com.healthpro.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepo;


    public List<Prescription> getAllPrescriptions(){
        final List<Prescription> prescriptionList = (List<Prescription>) prescriptionRepo.findAll();
        return prescriptionList;
    }


    public Prescription savePrescription(final Prescription prescription) {
        if(prescription.getPresc_id() == null) {
            return prescriptionRepo.save(prescription);
        } else  {
            final Optional<Prescription> searchPrescription = prescriptionRepo.findById(prescription.getPresc_id());
            if(searchPrescription.isPresent()) {
                Prescription updatePrescription = searchPrescription.get();
                updatePrescription.setPhysician((prescription.getPhysician()));
                updatePrescription.setPatient((prescription.getPatient()));
                updatePrescription.setDose((prescription.getDose()));
                updatePrescription.setDosage((prescription.getDosage()));
                return prescriptionRepo.save(updatePrescription);
            } else {
                return prescriptionRepo.save(prescription);
            }
        }
    }

    public Prescription getPrescriptionById(final Long id) throws RecordNotFoundException {
        final Optional<Prescription> prescriptionsList = prescriptionRepo.findById(id);
        if(prescriptionsList.isPresent()) {
            return prescriptionsList.get();
        } else {
            throw new RecordNotFoundException("No Patient Record Exists");
        }
    }

    public void deletePrescriptionById(final Long id) throws RecordNotFoundException {
        final Optional<Prescription> searchPrescription= prescriptionRepo.findById(id);
        if(searchPrescription.isPresent()) {
            prescriptionRepo.deleteById(id);
        } else  {
            throw new RecordNotFoundException("No PatientRecord Exists");
        }
    }

}
