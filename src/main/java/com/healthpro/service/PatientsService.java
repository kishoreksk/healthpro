package com.healthpro.service;


import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.PatientsRecord;
import com.healthpro.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {

    @Autowired
    PatientsRepository patientsRepo;

    public List<PatientsRecord> getAllPatientsRecord(){
        final List<PatientsRecord> patientsRecord = (List<PatientsRecord>) patientsRepo.findAll();
        return patientsRecord;
    }

    public PatientsRecord savePatientsRecord(final PatientsRecord patientsRecord) {
        if(patientsRecord.getId() == null) {
            return patientsRepo.save(patientsRecord);
        } else  {
            final Optional<PatientsRecord> searchPatientsRecord = patientsRepo.findById(patientsRecord.getId());
            if(searchPatientsRecord.isPresent()) {
                PatientsRecord updatePatientsRecord = searchPatientsRecord.get();
                updatePatientsRecord.setName((patientsRecord.getName()));
                updatePatientsRecord.setName((patientsRecord.getGender()));
                updatePatientsRecord.setName((patientsRecord.getAge()));
                updatePatientsRecord.setName((patientsRecord.getAddress()));
                updatePatientsRecord.setName((patientsRecord.getDisease()));
                updatePatientsRecord.setName((patientsRecord.getAdmission()));
                updatePatientsRecord.setName((patientsRecord.getDischarge()));
                return patientsRepo.save(updatePatientsRecord);
            } else {
                return patientsRepo.save(patientsRecord);
            }
        }
    }

    public PatientsRecord getPatientRecordById(final Long id) throws RecordNotFoundException {
        final Optional<PatientsRecord> patientsRecord = patientsRepo.findById(id);
        if(patientsRecord.isPresent()) {
            return patientsRecord.get();
        } else {
            throw new RecordNotFoundException("No Patient Record Exists");
        }
    }

    public void deletePatientsRecordById(final Long id) throws RecordNotFoundException {
        final Optional<PatientsRecord> searchPatientsRecord = patientsRepo.findById(id);
        if(searchPatientsRecord.isPresent()) {
            patientsRepo.deleteById(id);
        } else  {
            throw new RecordNotFoundException("No Patient Record Exists");
        }
    }
}
