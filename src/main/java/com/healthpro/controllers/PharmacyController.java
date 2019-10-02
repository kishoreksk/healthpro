package com.healthpro.controllers;

import com.healthpro.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping(value ="/home",method= RequestMethod.GET)
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
}
