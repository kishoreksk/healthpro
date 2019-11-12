package com.healthpro.controllers;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Prescription;
import com.healthpro.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PrescriptionController {


        @Autowired
        PrescriptionService prescriptionService;

        @RequestMapping(value = "show/prescription/",method = RequestMethod.GET)
        public String showPrescription(Model model){
            model.addAttribute("show_prescriptions", prescriptionService.getAllPrescriptions());
            return "show_prescriptions";
        }
    @RequestMapping(value = {"/show/prescription/{id}"}, method = RequestMethod.GET)
    public String showPatientsMedications(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final Prescription prescription = prescriptionService.getPrescriptionById(id.get());
            model.addAttribute("show_prescription", prescription);
        } else {
            model.addAttribute("show_prescription", new Prescription());
        }
        return "prescriptions";
    }
    @RequestMapping(value = "/save/prescription/", method = RequestMethod.POST)
    public String savePatientsRecord(final Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return "redirect:/show/prescriptions/";
    }

    @RequestMapping(value = {"/edit/prescription/", "/edit/prescription/{id}"}, method = RequestMethod.GET)
    public String editPatientsRecord(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final Prescription prescription = prescriptionService.getPrescriptionById(id.get());
            model.addAttribute("show_prescriptions", prescription);
        } else {
            model.addAttribute("show_prescriptions", new Prescription());
        }
        return "add_prescriptions";
    }

    @RequestMapping(value = "/delete/prescription/{id}")
    public String deletePatientsRecordById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        prescriptionService.deletePrescriptionById(id);
        return "redirect:/show/prescriptions/";
    }
}
