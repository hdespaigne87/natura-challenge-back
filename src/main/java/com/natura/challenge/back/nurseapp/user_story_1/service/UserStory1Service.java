package com.natura.challenge.back.nurseapp.user_story_1.service;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Validated
public interface UserStory1Service {

    Page<Patient> listPatients(Pageable pageable, Optional<String> filterByName, Optional<Integer> filterByAge);

    Page<VitalSign> listVitalSigns(@NotNull String patientId, Pageable pageable, Optional<LocalDate> filterByDate);

    void createPatient(@Valid Patient patient);

    void editPatient(@Valid Patient patient);

    void deletePatient(@NotEmpty String id);

    void createVitalSign(@Valid VitalSign vitalSign);

    void editVitalSign(@Valid VitalSign vitalSign);

    void deleteVitalSign(@NotEmpty String id);

    boolean existsPatientByDNI(@NotEmpty String dni, Optional<String> ignoreId);
}
