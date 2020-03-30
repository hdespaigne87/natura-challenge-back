package com.natura.challenge.back.nurseapp.repositories;

import com.natura.challenge.back.nurseapp.model.database.ViewVitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewVitalSignRepository extends
        JpaRepository<ViewVitalSign, String>, JpaSpecificationExecutor<ViewVitalSign> {

    List<ViewVitalSign> findAllByPatientIdAndMonthRegistrationAndYearRegistration(String patientId, Integer month, Integer year);
}
