package com.natura.challenge.back.nurseapp.model.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "view_vitalsigns")
public class ViewVitalSign implements Serializable {

    @Basic(optional = false)
    @Column(name = "id", insertable = false, updatable = false)
    @Id
    private String id;
    @Basic(optional = false)
    @Column(name = "patient_id")
    @NotNull
    private String patientId;
    @Basic(optional = false)
    @Column(name = "registration_moment")
    @NotNull
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm")
    private LocalDateTime registrationMoment;
    @Basic(optional = false)
    @Column(name = "blood_pressure_systolic")
    @NotNull
    private Integer bloodPressureSystolic;
    @Basic(optional = false)
    @Column(name = "blood_pressure_diastolic")
    @NotNull
    private Integer bloodPressureDiastolic;
    @Basic(optional = false)
    @Column(name = "heart_rate")
    @NotNull
    private Integer heartRate;
    @Basic(optional = false)
    @Column(name = "month_registration")
    private Integer monthRegistration;
    @Basic(optional = false)
    @Column(name = "year_registration")
    private Integer yearRegistration;
}
