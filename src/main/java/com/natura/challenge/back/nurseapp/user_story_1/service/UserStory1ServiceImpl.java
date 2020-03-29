package com.natura.challenge.back.nurseapp.user_story_1.service;

import com.natura.challenge.back.nurseapp.model.Patient;
import com.natura.challenge.back.nurseapp.repositories.PatientRepository;
import com.natura.challenge.back.nurseapp.repositories.VitalSignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStory1ServiceImpl implements UserStory1Service {

    private final PatientRepository patientRepository;
    private final VitalSignRepository vitalSignRepository;

    @Override
    public Page<Patient> listPatients(Pageable pageable, Optional<String> filterByName, Optional<Integer> filterByAge) {
        Specification filters = Specification.where(null);
        if (filterByName.isPresent()) {
            Specification filterName = (root, query, cb) -> {
                return cb.like(root.get("name"), "%" + filterByName.get() + "%");
            };
            filters = filters.and(filterName);
        }
        return patientRepository.findAll(filters, pageable);
    }
}
