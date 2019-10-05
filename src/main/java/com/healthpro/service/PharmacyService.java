package com.healthpro.service;

import com.healthpro.Exception.RecordNotFoundException;
import com.healthpro.model.Pharmacy;
import com.healthpro.model.PharmacyDetail;
import com.healthpro.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepo;

    public Pharmacy getPharmacy() {
        final Pharmacy pharmacy  = new Pharmacy(Long.valueOf(1),"Walgreen","Fremont");
        return pharmacy;

    }

//    public List<Pharmacy> getAllPharmacies() {
//        final List<Pharmacy> pharmacies = new ArrayList<Pharmacy>();
//        pharmacies.add(new Pharmacy(Long.valueOf(1),"Walgreen","Fremont"));
//        pharmacies.add(new Pharmacy(Long.valueOf(2),"Walmart","San Francisco"));
//        pharmacies.add(new Pharmacy(Long.valueOf(3),"Costco","New  York"));
//        pharmacies.add(new Pharmacy(Long.valueOf(4),"CVS","Washington"));
//        return pharmacies;
//    }

    public List<Pharmacy> getAllPharmacies() {
        final List<Pharmacy> pharmacies = (List<Pharmacy>) pharmacyRepo.findAll();
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




    public Pharmacy savePharmacy(final Pharmacy pharmacy) {
        if(pharmacy.getId() == null) {
            return pharmacyRepo.save(pharmacy);
        } else {
            final Optional<Pharmacy> searchPharmacy = pharmacyRepo.findById(pharmacy.getId());
            if(searchPharmacy.isPresent()){
                Pharmacy updatePharmacy = searchPharmacy.get();
                updatePharmacy.setName(pharmacy.getName());
                updatePharmacy.setCity(pharmacy.getCity());
                return pharmacyRepo.save(updatePharmacy);

            } else {
                return pharmacyRepo.save(pharmacy);
            }
        }

    }

    public Pharmacy getPharmacyById(final Long id) throws RecordNotFoundException {
        final Optional<Pharmacy> pharmacy = pharmacyRepo.findById(id);
        if (pharmacy.isPresent()) {
            return pharmacy.get();
        } else {
            throw new RecordNotFoundException("No Pharmacy Record Exists");
        }
    }

    public void deletePharmacyById(final Long id) throws RecordNotFoundException {
        final Optional<Pharmacy> searchPharmacy = pharmacyRepo.findById(id);
        if(searchPharmacy.isPresent()) {
            pharmacyRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Pharmacy Record Exists");
        }
    }

}
