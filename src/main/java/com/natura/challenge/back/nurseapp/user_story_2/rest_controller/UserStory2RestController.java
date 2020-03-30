package com.natura.challenge.back.nurseapp.user_story_2.rest_controller;

import com.natura.challenge.back.nurseapp.model.dto.VitalSignEvaluation;
import com.natura.challenge.back.nurseapp.user_story_2.service.UserStory2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userStory2")
@RequiredArgsConstructor
public class UserStory2RestController {

    private final UserStory2Service userStory2Service;

    @GetMapping("/vitalSignsEvaluation/{id}")
    public ResponseEntity<?> getVitalSignsEvaluation(@PathVariable(value = "id") String id) {
        VitalSignEvaluation result = userStory2Service.getVitalSignsEvaluation(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
