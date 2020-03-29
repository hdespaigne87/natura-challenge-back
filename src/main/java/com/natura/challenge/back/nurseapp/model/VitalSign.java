package com.natura.challenge.back.nurseapp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "vital_sign")
public class VitalSign implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid-vital_sign")
    @GenericGenerator(name = "system-uuid-vital_sign", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne
    private Patient patient;
    @Basic(optional = false)
    @Column(name = "registration_moment")
    private LocalDateTime registrationMoment;
    @Basic(optional = false)
    @Column(name = "blood_pressure_systolic")
    private Integer bloodPressureSystolic;
    @Basic(optional = false)
    @Column(name = "blood_pressure_piastolic")
    private Integer bloodPressureDiastolic;
    @Basic(optional = false)
    @Column(name = "heart_rate")
    private Integer heartRate;
}
