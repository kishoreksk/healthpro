package com.healthpro.service;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Medications;
import com.healthpro.repository.MedicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationsService {

    @Autowired
    MedicationsRepository medicationsRepo;

    public List<Medications> getAllPatientsMedications(){
        final List<Medications> medicationsList = (List<Medications>) medicationsRepo.findAll();
        return medicationsList;
    }

    public Medications savePatientsMedications(final Medications medications) {
        if(medications.getDrug_id() == null) {
            return medicationsRepo.save(medications);
        } else  {
            final Optional<Medications> searchPatientsMedications = medicationsRepo.findById(medications.getDrug_id());
            if(searchPatientsMedications.isPresent()) {
                Medications updatePatientsMedications = searchPatientsMedications.get();
                updatePatientsMedications.setDrug_name((medications.getDrug_name()));
                updatePatientsMedications.setDrug_type((medications.getDrug_type()));
                updatePatientsMedications.setDose((medications.getDose()));
                updatePatientsMedications.setDosage((medications.getDosage()));
                return medicationsRepo.save(updatePatientsMedications);
            } else {
                return medicationsRepo.save(medications);
            }
        }
    }

    public Medications getPatientsMedicationsById(final Long id) throws RecordNotFoundException {
        final Optional<Medications> medications = medicationsRepo.findById(id);
        if(medications.isPresent()) {
            return medications.get();
        } else {
            throw new RecordNotFoundException("No Patient Record Exists");
        }
    }

    public void deletePatientsRecordById(final Long id) throws RecordNotFoundException {
        final Optional<Medications> searchPatientsMedications= medicationsRepo.findById(id);
        if(searchPatientsMedications.isPresent()) {
            medicationsRepo.deleteById(id);
        } else  {
            throw new RecordNotFoundException("No PatientRecord Exists");
        }
    }


}
