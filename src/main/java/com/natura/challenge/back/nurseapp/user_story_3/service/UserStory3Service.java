package com.natura.challenge.back.nurseapp.user_story_3.service;

import com.natura.challenge.back.nurseapp.model.database.Patient;
import com.natura.challenge.back.nurseapp.model.database.ViewVitalSign;
import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface UserStory3Service {

    Patient findPatientByDNI(@NotEmpty String dni);

    List<ViewVitalSign> findVitalSignsByMonthAndYear(@NotEmpty String patientId,
                                                     @NotNull Integer month, @NotNull Integer year);
}
