package com.natura.challenge.back.nurseapp.user_story_1.service;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import com.natura.challenge.back.nurseapp.repositories.PatientRepository;
import com.natura.challenge.back.nurseapp.repositories.VitalSignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStory1ServiceImpl implements UserStory1Service {

    private final PatientRepository patientRepository;
    private final VitalSignRepository vitalSignRepository;

    @Override
    public Page<Patient> listPatients(Pageable pageable, Optional<String> filterByName, Optional<Integer> filterByAge) {
        //Init filter object with Spring Specification API
        Specification filters = Specification.where(null);

        //Configure filter for name
        if (filterByName.isPresent()) {
            Specification filter = (root, query, cb) -> {
                //WHERE name like %value%
                return cb.like(root.get("name"), "%" + filterByName.get() + "%");
            };
            filters = filters.and(filter);
        }

        //Configure filter for age
        if (filterByAge.isPresent()) {
            Specification filter = (root, query, cb) -> {
                //WHERE to_char(age) like %value%
                return cb.like(root.get("age").as(String.class), "%" + filterByAge.get() + "%");
            };
            filters = filters.and(filter);
        }

        return patientRepository.findAll(filters, pageable);
    }

    @Override
    public Page<VitalSign> listVitalSigns(String patientId, Pageable pageable, Optional<LocalDate> filterByDate) {
        //Init filter object with Spring Specification API
        Specification filters = Specification.where(null);

        //Configure filter for patient id
        Specification filterPatientId = (root, query, cb) -> {
            //WHERE patient_id = value
            return cb.equal(root.get("patient").get("id"), patientId);
        };
        filters = filters.and(filterPatientId);

        //Configure filter for registration moment
        if (filterByDate.isPresent()) {
            Specification filterDate = (root, query, cb) -> {
                //WHERE registration_moment = value
                return cb.equal(root.get("registrationMoment").as(LocalDate.class), filterByDate.get());
            };
            filters = filters.and(filterDate);
        }

        return vitalSignRepository.findAll(filters, pageable);
    }

    @Override
    @Transactional
    public void createPatient(@Valid Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void editPatient(@Valid Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void deletePatient(@NotEmpty String id) {
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void createVitalSign(@Valid VitalSign vitalSign) {
        vitalSignRepository.save(vitalSign);
    }

    @Override
    @Transactional
    public void editVitalSign(@Valid VitalSign vitalSign) {
        vitalSignRepository.save(vitalSign);
    }

    @Override
    @Transactional
    public void deleteVitalSign(@NotEmpty String id) {
        vitalSignRepository.deleteById(id);
    }

    @Override
    public boolean existsPatientByDNI(String dni, Optional<String> ignoreId) {
        if (ignoreId.isPresent())
            return patientRepository.existsByDniAndIdNot(dni, ignoreId.get());
        return patientRepository.existsByDni(dni);
    }
}
