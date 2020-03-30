package com.natura.challenge.back.nurseapp.user_story_1.rest_controller;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import com.natura.challenge.back.nurseapp.user_story_1.service.UserStory1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/patients/{id}/vitalSigns")
    public ResponseEntity<?> listVitalSigns(@PathVariable("id") String patientId,
                                            @RequestParam(value = "filterByDate", required = false) @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate filterByDate,
                                            Pageable pageable) {
        Page<VitalSign> result = userStory1Service.listVitalSigns(patientId, pageable, Optional.ofNullable(filterByDate));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/patients")
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        userStory1Service.createPatient(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/patients")
    public ResponseEntity<?> editPatient(@RequestBody Patient patient) {
        userStory1Service.editPatient(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") String id) {
        userStory1Service.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/vitalSigns")
    public ResponseEntity<?> createVitalSign(@RequestBody VitalSign vitalSign) {
        userStory1Service.createVitalSign(vitalSign);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/vitalSigns")
    public ResponseEntity<?> editVitalSign(@RequestBody VitalSign vitalSign) {
        userStory1Service.editVitalSign(vitalSign);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/vitalSigns/{id}")
    public ResponseEntity<?> deleteVitalSign(@PathVariable("id") String id) {
        userStory1Service.deleteVitalSign(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/existsPatientByDNI/{dni}")
    public ResponseEntity<?> existsPatientByDNI(@PathVariable(value = "dni") String dni,
                                                     @RequestParam(value = "ignoreId", required = false) String ignoreId) {
        boolean result = userStory1Service.existsPatientByDNI(dni, Optional.ofNullable(ignoreId));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
