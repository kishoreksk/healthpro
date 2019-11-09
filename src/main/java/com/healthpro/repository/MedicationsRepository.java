package com.healthpro.repository;

import com.healthpro.model.Medications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationsRepository extends CrudRepository<Medications,Long> {
}
