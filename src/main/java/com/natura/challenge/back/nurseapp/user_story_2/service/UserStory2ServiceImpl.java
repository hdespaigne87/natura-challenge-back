package com.natura.challenge.back.nurseapp.user_story_2.service;

import com.natura.challenge.back.nurseapp.model.database.VitalSign;
import com.natura.challenge.back.nurseapp.model.dto.VitalSignEvaluation;
import com.natura.challenge.back.nurseapp.repositories.VitalSignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStory2ServiceImpl implements UserStory2Service {

    private final VitalSignRepository vitalSignRepository;

    private boolean isInRange(Integer number, int min, int max) {
        return number > min && number <= max;
    }

    @Override
    public VitalSignEvaluation getVitalSignsEvaluation(String id) {
        VitalSignEvaluation vitalSignEvaluation = VitalSignEvaluation.builder().build();
        Optional<VitalSign> vitalSign = vitalSignRepository.findById(id);
        if (vitalSign.isPresent()) {
            Integer systolic = vitalSign.get().getBloodPressureSystolic();
            Integer diastolic = vitalSign.get().getBloodPressureDiastolic();
            //Evaluate blood pressure
            if (isInRange(systolic, 0, 120) && isInRange(diastolic, 0, 80))
                vitalSignEvaluation.setBloodPressure("NORMAL");
            else if (isInRange(systolic, 120, 129) && isInRange(diastolic, 0, 80))
                vitalSignEvaluation.setBloodPressure("ELEVATED");
            else if (isInRange(systolic, 129, 139) || isInRange(diastolic, 80, 89))
                vitalSignEvaluation.setBloodPressure("HIGH BLOOD PRESSURE (HYPERTENSION STAGE 1)");
            else if (isInRange(systolic, 139, 179) || isInRange(diastolic, 89, 119))
                vitalSignEvaluation.setBloodPressure("HIGH BLOOD PRESSURE (HYPERTENSION STAGE 2)");
            else if (isInRange(systolic, 179, Integer.MAX_VALUE) || isInRange(diastolic, 119, Integer.MAX_VALUE))
                vitalSignEvaluation.setBloodPressure("HYPERTENSIVE CRISIS (consult doctor inmediatly)");
            else
                vitalSignEvaluation.setBloodPressure("NOT NORMAL");

            Integer age = vitalSign.get().getPatient().getAge();
            Integer heartRate = vitalSign.get().getHeartRate();
            //Evalueate heart rates
            boolean normal = (isInRange(age, 0, 40) && heartRate <= 180)
                    || (isInRange(age, 40, 45) && heartRate <= 180)
                    || (isInRange(age, 45, 50) && heartRate <= 175)
                    || (isInRange(age, 50, 55) && heartRate <= 170)
                    || (isInRange(age, 55, 60) && heartRate <= 165)
                    || (isInRange(age, 60, 65) && heartRate <= 160)
                    || (isInRange(age, 65, 70) && heartRate <= 155)
                    || (isInRange(age, 70, Integer.MAX_VALUE) && heartRate <= 150);

            vitalSignEvaluation.setHeartRate(normal ? "NORMAL" : "NOT NORMAL");
        }
        return vitalSignEvaluation;
    }
}
