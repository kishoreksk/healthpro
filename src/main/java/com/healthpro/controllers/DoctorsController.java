package com.healthpro.controllers;

import com.healthpro.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DoctorsController {
    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/show/doctorprofiles/", method = RequestMethod.GET)
    public String showDoctorsProfile(Model model){
        model.addAttribute("doctors_profile",doctorService.getDoctorsProfile());
        return "doctors_profile";


    }
}
