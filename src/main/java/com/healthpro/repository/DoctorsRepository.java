package com.healthpro.repository;


import com.healthpro.model.DoctorsProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends CrudRepository<DoctorsProfile, Long> {

}
