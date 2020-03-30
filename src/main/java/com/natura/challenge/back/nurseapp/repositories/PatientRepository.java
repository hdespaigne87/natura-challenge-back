package com.natura.challenge.back.nurseapp.repositories;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends
        JpaRepository<Patient, String>, JpaSpecificationExecutor<Patient> {

    Optional<Patient> findByDni(String dni);

    boolean existsByDni(String dni);

    boolean existsByDniAndIdNot(String dni, String ignoreId);
}
