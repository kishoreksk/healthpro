package com.healthpro.controllers;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Appointment;
import com.healthpro.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value = "/show/appointments/", method = RequestMethod.GET)
    public String showAppointments(Model model){
        model.addAttribute("show_appointments", appointmentService.getAllAppointments());
        return "show_appointments";
    }

    @RequestMapping (value = "/save/appointments/", method = RequestMethod.POST)
    public String saveAppointment(final Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/show/appointments/";

    }
    @RequestMapping(value = {"/make/appointments/", "/make/appointments/{id}"}, method = RequestMethod.GET)
    public String makeAppointments(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if(id.isPresent()){
            final Appointment appointment = appointmentService.getAppointmentsById(id.get());
            model.addAttribute("show_appointments", appointment);
        } else {
            model.addAttribute("show_appointments", new Appointment());
        }
        return "make_appointments";
    }
}
