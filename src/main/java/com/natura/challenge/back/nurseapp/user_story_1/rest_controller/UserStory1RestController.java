package com.natura.challenge.back.nurseapp.user_story_1.rest_controller;

import com.natura.challenge.back.nurseapp.model.Patient;
import com.natura.challenge.back.nurseapp.user_story_1.service.UserStory1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/userStory1")
@RequiredArgsConstructor
public class UserStory1RestController {

    private final UserStory1Service userStory1Service;

    @GetMapping("/patients")
    public ResponseEntity<?> listPatients(@RequestParam(value = "filterByName", required = false) String filterByName,
                                          @RequestParam(value = "filterByAge", required = false) Integer filterByAge,
                                          Pageable pageable) {
        Page<Patient> result = userStory1Service.listPatients(pageable,
                Optional.ofNullable(filterByName), Optional.ofNullable(filterByAge));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
