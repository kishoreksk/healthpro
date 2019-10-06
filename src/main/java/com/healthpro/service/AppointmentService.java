package com.healthpro.service;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Appointment;
import com.healthpro.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepo;


    public List<Appointment> getAllAppointments(){
        final List<Appointment> appointment = (List<Appointment>) appointmentRepo.findAll();
        return appointment;
    }

    public Appointment saveAppointment(final Appointment appointment) {
        if(appointment.getId() == null) {
            return appointmentRepo.save(appointment);
        } else  {
            final Optional<Appointment> searchAppointment = appointmentRepo.findById(appointment.getId());
            if(searchAppointment.isPresent()) {
                Appointment updatePatientsRecord = searchAppointment.get();
                updatePatientsRecord.setName((appointment.getName()));
                updatePatientsRecord.setAge((appointment.getAge()));
                updatePatientsRecord.setGender((appointment.getGender()));
                updatePatientsRecord.setAddress((appointment.getAddress()));
                updatePatientsRecord.setContact((appointment.getContact()));
                updatePatientsRecord.setDoctor((appointment.getDoctor()));
                updatePatientsRecord.setDisease((appointment.getDisease()));
                updatePatientsRecord.setDate((appointment.getDate()));
                updatePatientsRecord.setTime((appointment.getTime()));
                return appointmentRepo.save(updatePatientsRecord);
            } else {
                return appointmentRepo.save(appointment);
            }
        }
    }
    public Appointment getAppointmentsById(final Long id) throws RecordNotFoundException {
        final Optional<Appointment>  appointment = appointmentRepo.findById(id);
        if(appointment.isPresent()) {
            return appointment.get();
        } else {
            throw new RecordNotFoundException("No Patient Record Exists");
        }
    }


}
