package com.tron.gymservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "medic_info")
@Data
public class UserMedicInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "medicSequence")
    @SequenceGenerator(name = "medicSequence", sequenceName = "Medic_SEQ",allocationSize = 1)
    private long id;
    private Boolean isDiabeticsPatient;
    private Boolean isCardiacPatient;
    private String note;
}
