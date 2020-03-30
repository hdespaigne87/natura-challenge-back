package com.natura.challenge.back.nurseapp.user_story_3.service;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import com.natura.challenge.back.nurseapp.model.database.ViewVitalSign;
import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import com.natura.challenge.back.nurseapp.model.dto.VitalSignEvaluation;
import com.natura.challenge.back.nurseapp.repositories.PatientRepository;
import com.natura.challenge.back.nurseapp.repositories.ViewVitalSignRepository;
import com.natura.challenge.back.nurseapp.repositories.VitalSignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStory3ServiceImpl implements UserStory3Service {

    private final PatientRepository patientRepository;
    private final ViewVitalSignRepository viewVitalSignRepository;

    @Override
    public Patient findPatientByDNI(@NotEmpty String dni) {
        Optional<Patient> patientOptional = patientRepository.findByDni(dni);
        if (patientOptional.isPresent())
            return patientOptional.get();
        return null;
    }

    @Override
    public List<ViewVitalSign> findVitalSignsByMonthAndYear(String patientId, Integer month, Integer year) {
        return viewVitalSignRepository.findAllByPatientIdAndMonthRegistrationAndYearRegistration(patientId, month, year);
    }
}
