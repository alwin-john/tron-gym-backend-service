package com.tron.gymservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usermaster_info")
@Data
@JsonIgnoreProperties(
        value = {"id"},
        allowGetters = true
)
public class UserMasterInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "userMasterIdSequence")
    @SequenceGenerator(name = "userMasterIdSequence", sequenceName = "UserMasterId_SEQ",allocationSize = 1)
    @Column(name = "userMaster_id")
    private long id;
    private String userName;
    private  String password;
    private String phoneNo;
    private String emailId;
    private int roleId;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
    @JoinColumn(name = "userMaster_id")
    private ClientEntity clientInfo;
}
