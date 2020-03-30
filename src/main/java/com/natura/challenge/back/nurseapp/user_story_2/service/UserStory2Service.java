package com.natura.challenge.back.nurseapp.user_story_2.service;

import com.natura.challenge.back.nurseapp.model.dto.VitalSignEvaluation;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Validated
public interface UserStory2Service {

    VitalSignEvaluation getVitalSignsEvaluation(@NotEmpty String id);
}
