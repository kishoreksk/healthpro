package com.healthpro.service;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.DoctorsProfile;
import com.healthpro.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService{

    @Autowired
    DoctorsRepository doctorsRepo;


    public DoctorsProfile getprofile() {
        final DoctorsProfile doctorsProfile = new DoctorsProfile(Long.valueOf(1), "Dr.Ranjani Suthir", "Physician", "Dermatology");
        return doctorsProfile;
    }
//    public List<DoctorsProfile> getDoctorsProfile(){
//        final List<DoctorsProfile> doctorsProfiles = new ArrayList<DoctorsProfile>();
//        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(1),"Dr.Ranjani Suthir","Physician","Dermatology"));
//        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(2),"Dr.kannan","Surgeon","Neurology"));
//        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(3),"Dr.Karnan","Surgeon","Cardiology"));
//        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(4),"Dr.Suthir","Physician","Psychiatrist"));
//        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(5),"Dr.Kishore","Surgeon","Ophthomology"));
//        return doctorsProfiles;
    //}
public List<DoctorsProfile> getAllDoctorProfiles() {
    final List<DoctorsProfile> doctorsProfiles = (List<DoctorsProfile>) doctorsRepo.findAll();
    return doctorsProfiles;

}


    public DoctorsProfile saveDoctorsProfile(final DoctorsProfile doctorsProfile) {
        if(doctorsProfile.getId() == null) {
            return doctorsRepo.save(doctorsProfile);
        } else {
            final Optional<DoctorsProfile> searchDoctorsProfile = doctorsRepo.findById(doctorsProfile.getId());
            if(searchDoctorsProfile.isPresent()){
                DoctorsProfile updateDoctorsProfile = searchDoctorsProfile.get();
                updateDoctorsProfile.setName(doctorsProfile.getName());
                updateDoctorsProfile.setType(doctorsProfile.getType());
                updateDoctorsProfile.setSpeciality(doctorsProfile.getSpeciality());
                return doctorsRepo.save(updateDoctorsProfile);

            } else {
                return doctorsRepo.save(doctorsProfile);
            }
        }

    }

    public DoctorsProfile getDoctorsProfileById(final Long id) throws RecordNotFoundException {
        final Optional<DoctorsProfile> doctorsProfile = doctorsRepo.findById(id);
        if (doctorsProfile.isPresent()) {
            return doctorsProfile.get();
        } else {
            throw new RecordNotFoundException("No Doctors Profile Record Exists");
        }
    }

    public void deleteDoctorsProfileById(final Long id) throws RecordNotFoundException {
        final Optional<DoctorsProfile> searchDoctorsProfile = doctorsRepo.findById(id);
        if(searchDoctorsProfile.isPresent()) {
            doctorsRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Doctors Profile Record Exists");

        }
    }


}
