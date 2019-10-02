package com.healthpro.service;

import com.healthpro.model.DoctorsProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService{
    public DoctorsProfile getprofile() {
        final DoctorsProfile doctorsprofile = new DoctorsProfile(Long.valueOf(1), "Dr.Ranjani Suthir", "Physician", "Dermatology");
        return doctorsprofile;
    }
    public List<DoctorsProfile> getDoctorsProfile(){
        final List<DoctorsProfile> doctorsProfiles = new ArrayList<DoctorsProfile>();
        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(1),"Dr.Ranjani Suthir","Physician","Dermatology"));
        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(2),"Dr.kannan","Surgeon","Neurology"));
        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(3),"Dr.Karnan","Surgeon","Cardiology"));
        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(4),"Dr.Suthir","Physician","Psychiatrist"));
        doctorsProfiles.add(new DoctorsProfile(Long.valueOf(5),"Dr.Kishore","Surgeon","Ophthomology"));
        return doctorsProfiles;

    }
}
