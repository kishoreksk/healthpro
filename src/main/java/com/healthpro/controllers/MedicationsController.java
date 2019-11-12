package com.healthpro.controllers;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Medications;
import com.healthpro.service.MedicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class MedicationsController {

    @Autowired
    MedicationsService medicationsService;

    @RequestMapping(value = "show/medications/",method = RequestMethod.GET)
    public String showMedications(Model model){
        model.addAttribute("patients_medications", medicationsService.getAllPatientsMedications());
        return "show_medications";
    }

    @RequestMapping(value = "reconcile/medications/",method = RequestMethod.GET)
    public String reconcileMedications(Model model){
        model.addAttribute("patients_medications", medicationsService.getAllPatientsMedications());
        return "medications";
    }
    @RequestMapping(value = {"/show/medications/{id}"}, method = RequestMethod.GET)
    public String showPatientsMedications(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final Medications medications = medicationsService.getPatientsMedicationsById(id.get());
            model.addAttribute("patients_medications", medications);
        } else {
            model.addAttribute("patients_medications", new Medications());
        }
        return "patients_medications";
    }
    @RequestMapping(value = "/save/medications/", method = RequestMethod.POST)
    public String savePatientsRecord(final Medications medications) {
        medicationsService.savePatientsMedications(medications);
        return "redirect:/reconcile/medications/";
    }

    @RequestMapping(value = {"/edit/medications/", "/edit/medications/{id}"}, method = RequestMethod.GET)
    public String editPatientsRecord(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final Medications medications = medicationsService.getPatientsMedicationsById(id.get());
            model.addAttribute("patients_medications", medications);
        } else {
            model.addAttribute("patients_medications", new Medications());
        }
        return "add_medications";
    }

    @RequestMapping(value = "/delete/medications/{id}")
    public String deletePatientsRecordById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        medicationsService.deletePatientsRecordById(id);
        return "redirect:/reconcile/medications/";
    }




}





