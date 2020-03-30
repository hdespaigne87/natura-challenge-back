package com.natura.challenge.back.nurseapp.user_story_3.rest_controller;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import com.natura.challenge.back.nurseapp.model.database.ViewVitalSign;
import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import com.natura.challenge.back.nurseapp.user_story_3.service.UserStory3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userStory3")
@RequiredArgsConstructor
public class UserStory3RestController {

    private final UserStory3Service userStory3Service;

    @GetMapping("/findPatientByDNI/{dni}")
    public ResponseEntity<?> findPatientByDNI(@PathVariable(value = "dni") String dni) {
        Patient result = userStory3Service.findPatientByDNI(dni);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findVitalSignsByMonthAndYear")
    public ResponseEntity<?> findVitalSignsByMonthAndYear(@RequestParam(value = "patientId") String patientId,
                                                          @RequestParam(value = "month") Integer month,
                                                          @RequestParam(value = "year") Integer year) {
        List<ViewVitalSign> result = userStory3Service.findVitalSignsByMonthAndYear(patientId, month, year);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
