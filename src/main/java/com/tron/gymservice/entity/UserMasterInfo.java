package com.tron.gymservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_master_info")
@Data
public class UserMasterInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "userMasterIdSequence")
    @SequenceGenerator(name = "userMasterIdSequence", sequenceName = "UserMasterId_SEQ",allocationSize = 1)
    private long id;
    private String userName;
    private String name;
    private  String password;
    private String phoneNo;
    private String emailId;
    private int roleId;
    private long adminId;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
    @JoinColumn(name = "userPhysicalInfoId", referencedColumnName = "id")
    private UserPhysicalInfo userPhysicalInfo;
}
