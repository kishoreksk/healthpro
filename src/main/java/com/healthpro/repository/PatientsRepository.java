package com.healthpro.repository;

import com.healthpro.model.PatientsRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends CrudRepository<PatientsRecord, Long> {
}
