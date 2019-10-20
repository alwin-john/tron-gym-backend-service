package com.tron.gymservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_physical_info")
@Data
public class UserPhysicalInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "userPhysicalInfoIdSequence")
    @SequenceGenerator(name = "userPhysicalInfoIdSequence", sequenceName = "UserPhysicalInfoId_SEQ",allocationSize = 1)
    private long id;
    private String bloodGroup;
    private int weight;
    private int height;
    private int fitnessPoint;
    private String activities;
    private String exerciseList;
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "userPhysicalInfo")
    private List<QandA> questions;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "medicInfoId", referencedColumnName = "id")
    private UserMedicInfo userMedicInfo;
//    @OneToOne(mappedBy = "user_physical_info")
//    private UserMasterInfo userMasterInfo;
}
