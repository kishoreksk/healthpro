package com.healthpro.controllers;



import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.PatientsRecord;
import com.healthpro.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PatientsController {
    @Autowired
    PatientsService patientService;

    @RequestMapping(value = "/show/patientsrecord/", method = RequestMethod.GET)
    public String showPatientsRecord(Model model) {
        model.addAttribute("patients_record", patientService.getAllPatientsRecord());
        return "patients_record";
    }

    @RequestMapping(value = "/save/patientsrecord/", method = RequestMethod.POST)
    public String savePatientsRecord(final PatientsRecord patientsRecord) {
        patientService.savePatientsRecord(patientsRecord);
        return "redirect:/show/patientsrecord/";
    }

    @RequestMapping(value = {"/edit/patientsrecord/", "/edit/patientsrecord/{id}"}, method = RequestMethod.GET)
    public String editPatientsRecord(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final PatientsRecord patientsRecord = patientService.getPatientRecordById(id.get());
            model.addAttribute("patients_record", patientsRecord);
        } else {
            model.addAttribute("patients_record", new PatientsRecord());
        }
        return "add_patients";
    }

    @RequestMapping(value = "/delete/patientsrecord/{id}")
    public String deletePatientsRecordById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        patientService.deletePatientsRecordById(id);
        return "redirect:/show/patientsrecord/";
    }

    @RequestMapping(value = {"/show/patientsrecord/{id}"}, method = RequestMethod.GET)
    public String showPatientsRecord(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final PatientsRecord patientsRecord = patientService.getPatientRecordById(id.get());
            model.addAttribute("patients_record", patientsRecord);
        } else {
            model.addAttribute("patients_record", new PatientsRecord());
        }
        return "patients_details";
    }
//    @RequestMapping(value = {"/show/patientsmedications/{id}"}, method = RequestMethod.GET)
//    public String showPatientsMedications(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
//        if (id.isPresent()) {
//            final PatientsRecord patientsRecord = patientService.getPatientRecordById(id.get());
//            model.addAttribute("patients_details", patientsRecord);
//        } else {
//            model.addAttribute("patients_details", new PatientsRecord());
//        }
//        return "medications";
//    }
//    @RequestMapping(value = {"/edit/medications/", "/edit/medications/{id}"}, method = RequestMethod.GET)
//    public String editMedicationsRecord(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
//        if (id.isPresent()) {
//            final PatientsRecord patientsRecord = patientService.getPatientRecordById(id.get());
//            model.addAttribute("patients_record", patientsRecord);
//        } else {
//            model.addAttribute("patients_record", new PatientsRecord());
//        }
//        return "add_medications";
//    }
//
//    @RequestMapping(value = "/save/medications/", method = RequestMethod.POST)
//    public String saveMedications(final PatientsRecord patientsRecord) {
//        patientService.savePatientsRecord(patientsRecord);
//        return "redirect:/show/patientsmedications/{id}";
//    }
}

