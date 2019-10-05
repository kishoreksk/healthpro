package com.healthpro.controllers;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Pharmacy;
import com.healthpro.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Optional;

@Controller
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping(value ="/",method= RequestMethod.GET)
    public String showPharmacy(Model model){
       // final Pharmacy pharmacy  = new Pharmacy("Walgreen","Fremont");
        model.addAttribute("pharmacy_name", pharmacyService.getPharmacy());
        return "home";
    }

    @RequestMapping(value ="/showAll",method= RequestMethod.GET)
    public String showAllPharmacies(Model model){
        // final Pharmacy pharmacy  = new Pharmacy("Walgreen","Fremont");
        model.addAttribute("pharmacies", pharmacyService.getAllPharmacies());
        return "show_all_pharmacies";
    }

    @RequestMapping(value ="/show/detail",method= RequestMethod.GET)
    public String showPharmacyDetail(Model model) {
        model.addAttribute("pharmacy_detail",pharmacyService.getPharmacyDetail());
        return "show_pharmacy_detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePharmacy(final Pharmacy pharmacy){
        pharmacyService.savePharmacy(pharmacy);
        return "redirect:/showAll";
    }

    @RequestMapping(value = {"/edit", "/edit/{id}"}, method = RequestMethod.GET)
    public String editPharmacy(Model model, @PathVariable("id")Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            final Pharmacy pharmacy = pharmacyService.getPharmacyById(id.get());
            model.addAttribute("pharmacy", pharmacy);
        } else {
            model.addAttribute("pharmacy", new Pharmacy());
        }
        return "add_pharmacy";

    }

    @RequestMapping(value = "/delete/{id}")
    public String deletePharmacyById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        pharmacyService.deletePharmacyById(id);
        return "redirect:/showAll";
    }



}
