package com.natura.challenge.back.nurseapp.repositories;

import com.natura.challenge.back.nurseapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends
        JpaRepository<Patient, String>, JpaSpecificationExecutor<Patient> {

}
