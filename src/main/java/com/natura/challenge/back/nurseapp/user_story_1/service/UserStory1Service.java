package com.natura.challenge.back.nurseapp.user_story_1.service;

import com.natura.challenge.back.nurseapp.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface UserStory1Service {

    Page<Patient> listPatients(Pageable pageable, Optional<String> filterByName, Optional<Integer> filterByAge);
}
