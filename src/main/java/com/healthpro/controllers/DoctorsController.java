package com.healthpro.controllers;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.DoctorsProfile;
import com.healthpro.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class DoctorsController {
    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/show/doctorsprofile/", method = RequestMethod.GET)
    public String showDoctorsProfile(Model model){
        model.addAttribute("doctors_profile",doctorService.getAllDoctorProfiles());
        return "doctors_profile";
    }
    @RequestMapping(value = "/save/doctorsprofile", method = RequestMethod.POST)
    public String saveDoctorsProfile(final DoctorsProfile doctorsProfile){
        doctorService.saveDoctorsProfile(doctorsProfile);
        return "redirect:/show/doctorsprofile/";
    }

    @RequestMapping(value = {"/edit/doctorsprofile/", "/edit/doctorsprofile/{id}"}, method = RequestMethod.GET)
    public String editDoctorsProfile(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final DoctorsProfile doctorsProfile = doctorService.getDoctorsProfileById(id.get());
            model.addAttribute("doctors_profile", doctorsProfile);
        } else {
            model.addAttribute("doctors_profile", new DoctorsProfile());
        }
        return "add_doctors_profile";

    }

    @RequestMapping(value = "/delete/doctorsprofile/{id}")
    public String deleteDoctorsProfileById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        doctorService.deleteDoctorsProfileById(id);
        return "redirect:/show/doctorsprofile/";
    }

}
