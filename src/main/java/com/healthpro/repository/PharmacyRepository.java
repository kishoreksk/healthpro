package com.healthpro.repository;


import com.healthpro.model.Pharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {


}
