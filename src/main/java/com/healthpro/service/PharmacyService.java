package com.healthpro.service;


import com.healthpro.model.Pharmacy;
import com.healthpro.model.PharmacyDetail;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class PharmacyService {

    public Pharmacy getPharmacy() {
        final Pharmacy pharmacy  = new Pharmacy(Long.valueOf(1),"Walgreen","Fremont");
        return pharmacy;

    }

    public List<Pharmacy> getAllPharmacies() {
        final List<Pharmacy> pharmacies = new ArrayList<Pharmacy>();
        pharmacies.add(new Pharmacy(Long.valueOf(1),"Walgreen","Fremont"));
        pharmacies.add(new Pharmacy(Long.valueOf(2),"Walmart","San Francisco"));
        pharmacies.add(new Pharmacy(Long.valueOf(3),"Costco","New  York"));
        pharmacies.add(new Pharmacy(Long.valueOf(4),"CVS","Washington"));
        return pharmacies;
    }

    public List<PharmacyDetail> getPharmacyDetail() {
        final List<PharmacyDetail> pharmacy_detail = new ArrayList<PharmacyDetail>();
        pharmacy_detail.add(new PharmacyDetail(Long.valueOf(1),"Walgreen","Fremont","https://www.walgreens.com/pharmacy/"));
        pharmacy_detail.add(new PharmacyDetail(Long.valueOf(2),"Walmart","San Francisco","https://www.walmart.com/cp/pharmacy/5431"));
        pharmacy_detail.add(new PharmacyDetail(Long.valueOf(3),"Costco","New York","https://www.costco.com/home-delivery"));
        pharmacy_detail.add(new PharmacyDetail(Long.valueOf(4),"CVS","Washington","http://www.cvs.com/"));
        return pharmacy_detail;
    }




}
