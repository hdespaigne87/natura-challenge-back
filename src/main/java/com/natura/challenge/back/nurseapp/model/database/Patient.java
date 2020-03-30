package com.natura.challenge.back.nurseapp.model.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "patient")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid-patient")
    @GenericGenerator(name = "system-uuid-patient", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "dni")
    @NotNull
    private String dni;
    @Basic(optional = false)
    @Column(name = "name")
    @NotNull
    private String name;
    @Basic(optional = false)
    @Column(name = "age")
    @NotNull
    private Integer age;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "patient")
    @JsonIgnore
    private List<VitalSign> vitalSigns;
}
